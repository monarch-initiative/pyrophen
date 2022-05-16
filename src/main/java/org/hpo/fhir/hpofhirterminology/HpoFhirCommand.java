package org.hpo.fhir.hpofhirterminology;

import org.hpo.fhir.hpofhirterminology.fhir.IFhirService;
import org.monarchinitiative.phenol.io.OntologyLoader;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "fhir")
public class HpoFhirCommand implements Callable<Integer> {
    @Autowired
    private IFhirService fhirService;

    @CommandLine.Option(names = "--hpo", description = "path to HPO obo file", required = true)
    String pathToHpo;

    @CommandLine.Option(names = "--out", description = "name/path of outfile", defaultValue = "hpo_fhir.json")
    String outfileName;

    @CommandLine.Option(names ="--format", description = "format of output file (JSON (default), XML)", defaultValue = "json")
    String outputFormat;

    /**
     * @return 0 if successful, 1 otherwise
     */
    public Integer call() {
        Ontology hpo = OntologyLoader.loadOntology(new File(pathToHpo));
        return fhirService.writeCodeSystem(hpo, outfileName, outputFormat);
    }

}
