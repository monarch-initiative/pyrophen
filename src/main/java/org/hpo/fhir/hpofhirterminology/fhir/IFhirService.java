package org.hpo.fhir.hpofhirterminology.fhir;

import org.monarchinitiative.phenol.ontology.data.Ontology;

public interface IFhirService {
    int writeCodeSystemXml(Ontology ontology, String filename);
}
