package org.hpo.fhir.hpofhirterminology.fhir;

import org.hl7.fhir.r4.model.CodeSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.monarchinitiative.phenol.io.OntologyLoader;
import org.monarchinitiative.phenol.ontology.data.Ontology;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class OntologyFHIRCodeSystemTest {

    private Ontology ontology;

    @Test
    public void OntologyFHIRCodeSystemTestCreateCodeSystem(@TempDir Path temp) {
        this.ontology = OntologyLoader.loadOntology(Paths.get("src/test/resources/hp_head.obo").toFile());
        String codeSystemUri = "http://purl.obolibrary.org/obo/hp.fhir";
        OntologyFHIRCodeSystem ontologyFHIRCodeSystem = new OntologyFHIRCodeSystem(codeSystemUri, ontology);
        CodeSystem codeSystem = ontologyFHIRCodeSystem.ontologyToCodeSystem(this.ontology);
        assertNotNull(codeSystem);
        // to write the code system to file,
        Path outFile = temp.resolve("fhirtest.xml");
        ontologyFHIRCodeSystem.writeCodeSystemXml(codeSystem, outFile.toString());
        System.out.println(outFile);
    }

    @Test
    public void testMetaDataCodeSystem() {
        // TODO: Test metadata function
    }
}