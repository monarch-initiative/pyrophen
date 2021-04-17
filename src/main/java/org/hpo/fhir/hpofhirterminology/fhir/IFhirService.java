package org.hpo.fhir.hpofhirterminology.fhir;

import org.monarchinitiative.phenol.ontology.data.Ontology;

public interface IFhirService {
    void writeCodeSystemXml(Ontology ontology, String filename);
}
