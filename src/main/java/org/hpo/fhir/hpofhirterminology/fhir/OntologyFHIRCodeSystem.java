package org.hpo.fhir.hpofhirterminology.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.*;
import org.monarchinitiative.phenol.ontology.algo.OntologyAlgorithm;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.monarchinitiative.phenol.ontology.data.Term;
import org.monarchinitiative.phenol.ontology.data.TermId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class OntologyFHIRCodeSystem {

    private final CodeSystem codeSystem = new CodeSystem();
    private final Ontology ontology;

    public OntologyFHIRCodeSystem(String codeSystemUri, Ontology ontology) {
        final String description = "A FHIR code system representation of the Human Phenotype Ontology.";
        final String version = "release/019293m3";
        final String title = "Human Phenotype Ontology Coding";
        final String name = "HPO";
        final String publisher = "The Human Phenotype Ontology";
        final String purpose = "To provide a standardized vocabulary of human phenotypes encountered in human disease in a FHIR context.";
        setCodeSystemMetadata(codeSystemUri, description, version, title, name, publisher, purpose);
        ontologyToCodeSystem(ontology);
        this.ontology = Objects.requireNonNull(ontology);
    }

    public void writeCodeSystemXml(CodeSystem codeSystem, String filename) {
        FhirContext ctx = FhirContext.forR4();
        IParser parser = ctx.newXmlParser();
        // Indent the output
        parser.setPrettyPrint(true);
        String serialized = parser.encodeResourceToString(codeSystem);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(serialized);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CodeSystem ontologyToCodeSystem(Ontology ontology) {
        Set<TermId> termIds = ontology.getNonObsoleteTermIds();
        List<CodeSystem.ConceptDefinitionComponent> componentList = new ArrayList<>();
        for (TermId tid : termIds) {
            Term term = ontology.getTermMap().get(tid);
            if (term == null) {
                System.err.println("Could not find term for " + tid.getValue());
                continue;
            }
            CodeType hpoCodeType = new CodeType(tid.getValue());
            CodeSystem.ConceptDefinitionComponent component = new CodeSystem.ConceptDefinitionComponent(hpoCodeType);
            component.setDefinition(term.getDefinition());
            component.setId(tid.getValue());
            component.setCode(term.getName());
            Set<TermId> parents = OntologyAlgorithm.getParentTerms(ontology, tid, false);
            for (TermId parent : parents) {
                final CodeSystem.ConceptPropertyComponent parentProp = component.addProperty();
                parentProp.setCode("parent");
                parentProp.setValue(new CodeType(parent.getValue()));
            }
            componentList.add(component);
        }
        codeSystem.setConcept(componentList);
        return codeSystem;
    }

    private void setCodeSystemMetadata(String codeSystemUri, String description, String version, String title,
                                       String name, String publisher, String purpose) {
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
