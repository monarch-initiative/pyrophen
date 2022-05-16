.. _rstexamplejson:

##############
Example (JSON)
##############

pyrophen outputs the codeset in XML or JSON format. See :ref:`rstexamplexml` for XML.

The test class ``HpoFhirTerminologyApplicationTests`` writes a temporary file with the CodeSystem created for a small excerpt of the HPO located
in ``src/test/resources/hp_head.obo``.


This is the JSON file that is produced.


.. code-block:: bash

    {
      "resourceType": "CodeSystem",
      "id": "hpo",
      "url": "http://purl.obolibrary.org/obo/hp.fhir",
      "version": "http://purl.obolibrary.org/obo/hp/releases/2017-04-13/hp.owl",
      "name": "HPO",
      "title": "Human Phenotype Ontology Coding",
      "status": "active",
      "experimental": false,
      "date": "2021-05-03T08:04:39-04:00",
      "publisher": "The Human Phenotype Ontology",
      "contact": [ {
        "name": "Peter N. Robinson"
      } ],
      "description": "A FHIR code system representation of the Human Phenotype Ontology.",
      "purpose": "To provide a standardized vocabulary of human phenotypes encountered in human disease in a FHIR context.",
      "copyright": "https://hpo.jax.org/app/license",
      "concept": [ {
        "code": "HP:0000001",
        "display": "All"
      }, {
        "code": "HP:0040282",
        "display": "Frequent",
        "definition": "Present in 30% to 79% of the cases.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0040279"
        } ]
      }, {
        "code": "HP:0040281",
        "display": "Very frequent",
        "definition": "Present in 80% to 99% of the cases.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0040279"
        } ]
      }, {
        "code": "HP:0040284",
        "display": "Very rare",
        "definition": "Present in 1% to 4% of the cases.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0040279"
        } ]
      }, {
        "code": "HP:0040280",
        "display": "Obligate",
        "definition": "Always present, i.e. in 100% of the cases.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0040279"
        } ]
      }, {
        "code": "HP:0100886",
        "display": "Abnormality of globe location",
        "definition": "An abnormality in the placement of the ocular globe (eyeball).",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0012374"
        } ]
      }, {
        "code": "HP:0012374",
        "display": "Abnormal globe morphology",
        "definition": "An anomaly of the eyeball.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0012372"
        } ]
      }, {
        "code": "HP:0040279",
        "display": "Frequency",
        "definition": "Class to represent frequency of phenotypic abnormalities within a patient cohort.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000001"
        } ]
      }, {
        "code": "HP:0100887",
        "display": "Abnormality of globe size",
        "definition": "An abnormality in the size of the ocular globe (eyeball).",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0012374"
        } ]
      }, {
        "code": "HP:0000528",
        "display": "Anophthalmia",
        "definition": "Absence of the globe or eyeball.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0100887"
        } ]
      }, {
        "code": "HP:0040285",
        "display": "Excluded",
        "definition": "Present in 0% of the cases.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0040279"
        } ]
      }, {
        "code": "HP:0012372",
        "display": "Abnormal eye morphology",
        "definition": "A structural anomaly of the eye.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000478"
        } ]
      }, {
        "code": "HP:0012373",
        "display": "Abnormal eye physiology",
        "definition": "A functional anomaly of the eye.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000478"
        } ]
      }, {
        "code": "HP:0000118",
        "display": "Phenotypic abnormality",
        "definition": "A phenotypic abnormality.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000001"
        } ]
      }, {
        "code": "HP:0000007",
        "display": "Autosomal recessive inheritance",
        "definition": "A mode of inheritance that is observed for traits related to a gene encoded on one of the autosomes (i.e., the human chromosomes 1-22) in which a trait manifests in homozygotes. In the context of medical genetics, autosomal recessive disorders manifest in homozygotes (with two copies of the mutant allele) or compound heterozygotes (whereby each copy of a gene has a distinct mutant allele).",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000005"
        } ]
      }, {
        "code": "HP:0000568",
        "display": "Microphthalmia",
        "definition": "A developmental anomaly characterized by abnormal smallness of one or both eyes.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0100887"
        } ]
      }, {
        "code": "HP:0007686",
        "display": "Abnormal pupillary function",
        "definition": "A functional abnormality of the pupil.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0012373"
        } ]
      }, {
        "code": "HP:0000006",
        "display": "Autosomal dominant inheritance",
        "definition": "A mode of inheritance that is observed for traits related to a gene encoded on one of the autosomes (i.e., the human chromosomes 1-22) in which a trait manifests in heterozygotes. In the context of medical genetics, an autosomal dominant disorder is caused when a single copy of the mutant allele is present. Males and females are affected equally, and can both transmit the disorder with a risk of 50% for each child of inheriting the mutant allele.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000005"
        } ]
      }, {
        "code": "HP:0000478",
        "display": "Abnormality of the eye",
        "definition": "Any abnormality of the eye, including location, spacing, and intraocular abnormalities.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000118"
        } ]
      }, {
        "code": "HP:0000632",
        "display": "Lacrimation abnormality",
        "definition": "Abnormality of tear production.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0012373"
        } ]
      }, {
        "code": "HP:0000005",
        "display": "Mode of inheritance",
        "definition": "The pattern in which a particular genetic trait or disorder is passed from one generation to the next.",
        "property": [ {
          "code": "parent",
          "valueCode": "HP:0000001"
        } ]
      } ]
    }
