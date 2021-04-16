package org.hpo.fhir.hpofhirterminology;

import org.hl7.fhir.r4.model.CodeSystem;
import org.hpo.fhir.hpofhirterminology.fhir.OntologyFHIRCodeSystem;
import org.monarchinitiative.phenol.io.OntologyLoader;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class CliMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Ontology hpo = OntologyLoader.loadOntology(Paths.get(args[0]).toFile());
        OntologyFHIRCodeSystem ontologyFHIRCodeSystem = new OntologyFHIRCodeSystem("http://purl.obolibrary.org/obo/hp.fhir", hpo);
        CodeSystem codeSystem = ontologyFHIRCodeSystem.ontologyToCodeSystem(hpo);
        ontologyFHIRCodeSystem.writeCodeSystemXml(codeSystem, args[1]);
        System.out.println("Written file " + args[1]);
    }
}
