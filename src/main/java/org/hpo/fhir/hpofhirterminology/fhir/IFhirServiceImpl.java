package org.hpo.fhir.hpofhirterminology.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.resource.ValueSet;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.*;
import org.monarchinitiative.phenol.ontology.algo.OntologyAlgorithm;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.monarchinitiative.phenol.ontology.data.Term;
import org.monarchinitiative.phenol.ontology.data.TermId;
import org.monarchinitiative.phenol.ontology.data.TermSynonym;
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

    public IFhirServiceImpl(String codeSystemUri) {

    }

    /**
     * Write the code system XML file.
     * @param ontology The HPO ontology
     * @param filename Path/name of output file
     * @return 0 upon success, 1 otherwise
     */
    @Override
    public int writeCodeSystemXml(Ontology ontology, String filename) {
        CodeSystem codeSystem = ontologyToCodeSystem(ontology);
        setCodeSystemMetadata(codeSystem);
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
            List<TermSynonym> synonyms = term.getSynonyms();
            for (TermSynonym tsyn : synonyms) {
                CodeSystem.ConceptDefinitionDesignationComponent designationComponent =
                        new CodeSystem.ConceptDefinitionDesignationComponent();
                designationComponent.setUse(SYNONYM).setValue(tsyn.getValue());

                component.addDesignation(designationComponent);
            }
            componentList.add(component);
        }
        CodeSystem codeSystem = new CodeSystem();
        codeSystem.setConcept(componentList);
        return codeSystem;
    }

    private void setCodeSystemMetadata(CodeSystem codeSystem) {

        final String description = "A FHIR code system representation of the Human Phenotype Ontology.";
        final String version = "release/019293m3";
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
        final ContactDetail contact = new ContactDetail().setName("Peter N. Robinson");
        codeSystem.setContact(Collections.singletonList(contact));
        codeSystem.setDescription(description);
        codeSystem.setPurpose(purpose);
    }
}
