package org.hpo.fhir.hpofhirterminology.fhir;

import org.monarchinitiative.phenol.ontology.data.Ontology;

public interface IFhirService {


    int writeCodeSystem(Ontology ontology, String filename, String outputformat);
}
