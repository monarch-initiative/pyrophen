package org.hpo.fhir.hpofhirterminology.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyType;
import org.hpo.fhir.hpofhirterminology.except.HpoFhirRuntimeException;
import org.monarchinitiative.phenol.ontology.algo.OntologyAlgorithm;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.monarchinitiative.phenol.ontology.data.Term;
import org.monarchinitiative.phenol.ontology.data.TermId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service("FhirService")
public class IFhirServiceImpl implements IFhirService{

    private static final Logger LOGGER= LoggerFactory.getLogger(IFhirServiceImpl.class);

    private static final Coding SYNONYM = new Coding()
            .setCode("900000000000013009")
            .setDisplay("Synonym (core metadata concept)")
            .setSystem("http://snomed.info/sct");

    public IFhirServiceImpl() {
    }

    /**
     * Write the code system XML file.
     * @param ontology The HPO ontology
     * @param filename Path/name of output file
     * @return 0 upon success, 1 otherwise
     */
    @Override
    public int writeCodeSystem(Ontology ontology, String filename, String outputformat) {
        CodeSystem codeSystem = ontologyToCodeSystem(ontology);
        setCodeSystemMetadata(codeSystem, ontology);
        if (outputformat.equalsIgnoreCase("XML")) {
            return writeCodeSystemXML(codeSystem, filename);
        } else if (outputformat.equalsIgnoreCase("JSON")) {
            return writeCodeSystemJSON(codeSystem, filename);
        } else {
            throw new HpoFhirRuntimeException("Unrecognized output format: \"" + outputformat + "\"");
        }
    }


    private int writeCodeSystemJSON(CodeSystem codeSystem, String filename) {
        FhirContext ctx = FhirContext.forR4();
        IParser parser = ctx.newJsonParser();
        parser.setPrettyPrint(true);
        String serialized = parser.encodeResourceToString(codeSystem);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(serialized);
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }


    private int writeCodeSystemXML(CodeSystem codeSystem, String filename) {
        FhirContext ctx = FhirContext.forR4();
        IParser parser = ctx.newXmlParser();
        // Indent the output
        parser.setPrettyPrint(true);
        String serialized = parser.encodeResourceToString(codeSystem);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(serialized);
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        LOGGER.info("Wrote FHIR HPO Code system");
        return 0;
    }




    private CodeSystem ontologyToCodeSystem(Ontology ontology) {
        Set<TermId> termIds = ontology.getNonObsoleteTermIds();
        List<CodeSystem.ConceptDefinitionComponent> componentList = new ArrayList<>();
        for (TermId tid : termIds) {
            Term term = ontology.getTermMap().get(tid);
            if (term == null) {
                System.err.println("Could not find term for " + tid.getValue());
                continue;
            }
            CodeType hpoCodeType = new CodeType();

            CodeSystem.ConceptDefinitionComponent component = new CodeSystem.ConceptDefinitionComponent(hpoCodeType);
            component.setDefinition(term.getDefinition());
            component.setCode(tid.getValue());
            component.setDisplay(term.getName());
            Set<TermId> parents = OntologyAlgorithm.getParentTerms(ontology, tid, false);
            for (TermId parent : parents) {
                final CodeSystem.ConceptPropertyComponent parentProp = component.addProperty();
                parentProp.setCode("parent");
                parentProp.setValue(new CodeType(parent.getValue()));
            }
            /*List<TermSynonym> synonyms = term.getSynonyms();
            for (TermSynonym tsyn : synonyms) {
                CodeSystem.ConceptDefinitionDesignationComponent designationComponent =
                        new CodeSystem.ConceptDefinitionDesignationComponent();
                designationComponent.setUse(SYNONYM).setValue(tsyn.getValue());

                component.addDesignation(designationComponent);
            }*/
            componentList.add(component);
        }
        CodeSystem codeSystem = new CodeSystem();
        codeSystem.setConcept(componentList);
        return codeSystem;
    }

    private void setCodeSystemMetadata(CodeSystem codeSystem, Ontology ontology) {
        final Map<String,String> hpoMetainfo = ontology.getMetaInfo();
        if (! hpoMetainfo.containsKey("data-version")) {
            throw new HpoFhirRuntimeException("Could not find data-version in HPO object");
        }
        final String description = "A FHIR code system representation of the Human Phenotype Ontology.";
        final String version = hpoMetainfo.get("data-version");
        final String title = "Human Phenotype Ontology Coding";
        final String name = "HPO";
        final String publisher = "The Human Phenotype Ontology";
        final String purpose = "To provide a standardized vocabulary of human phenotypes encountered in human disease in a FHIR context.";
        final String codeSystemUri = "http://purl.obolibrary.org/obo/hp.fhir";

        codeSystem.setUrl(codeSystemUri);
        codeSystem.setId(name.toLowerCase());
        codeSystem.setVersion(version);
        codeSystem.setName(name);
        codeSystem.setTitle(title);
        codeSystem.setStatus(Enumerations.PublicationStatus.ACTIVE);
        codeSystem.setExperimental(false);
        codeSystem.setDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        codeSystem.setPublisher(publisher);
        codeSystem.setCopyright("https://hpo.jax.org/app/license");
        final ContactDetail contact = new ContactDetail().setName("Peter N. Robinson");
        codeSystem.setContact(Collections.singletonList(contact));
        codeSystem.setDescription(description);
        codeSystem.setPurpose(purpose);
        PropertyComponent parent  = codeSystem.addProperty();
        parent.setCode("parent");
        parent.setUri("http://hl7.org/fhir/concept-properties");
        parent.setType(PropertyType.CODE);
        parent.setDescription("The concept identified in this property is a parent of the concept on which it is a property. "
            + "The property type will be 'code'. "
            + "The meaning of 'parent' is defined by the hierarchyMeaning attribute. "
            + "See: https://hl7.org/fhir/R4/codesystem-concept-properties.html");
    }
}