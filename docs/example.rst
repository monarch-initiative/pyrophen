.. _rstexample:

#######
Example
#######

The test class ``HpoFhirTerminologyApplicationTests`` writes a temporary file with the CodeSystem created for a small excerpt of the HPO located
in ``src/test/resources/hp_head.obo``.


This is the XML file that is produced.



.. code-block:: bash

  <CodeSystem xmlns="http://hl7.org/fhir">
    <id value="hpo"></id>
    <url value="http://purl.obolibrary.org/obo/hp.fhir"></url>
    <version value="http://purl.obolibrary.org/obo/hp/releases/2017-04-13/hp.owl"></version>
    <name value="HPO"></name>
    <title value="Human Phenotype Ontology Coding"></title>
    <status value="active"></status>
    <experimental value="false"></experimental>
    <date value="2021-04-18T14:30:10-04:00"></date>
    <publisher value="The Human Phenotype Ontology"></publisher>
    <contact>
      <name value="Peter N. Robinson"></name>
    </contact>
    <description value="A FHIR code system representation of the Human Phenotype Ontology."></description>
    <purpose value="To provide a standardized vocabulary of human phenotypes encountered in human disease in a FHIR context."></purpose>
    <copyright value="https://hpo.jax.org/app/license"></copyright>
    <concept>
      <code value="HP:0000001"></code>
      <display value="All"></display>
    </concept>
    <concept>
      <code value="HP:0040282"></code>
      <display value="Frequent"></display>
      <definition value="Present in 30% to 79% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Frequent (79-30%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040281"></code>
      <display value="Very frequent"></display>
      <definition value="Present in 80% to 99% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Very frequent (99-80%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040284"></code>
      <display value="Very rare"></display>
      <definition value="Present in 1% to 4% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Very rare (&lt;4-1%)"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Very rare (&amp;lt;4-1%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040283"></code>
      <display value="Occasional"></display>
      <definition value="Present in 5% to 29% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Occasional (29-5%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040280"></code>
      <display value="Obligate"></display>
      <definition value="Always present, i.e. in 100% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Obligate (100%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0100886"></code>
      <display value="Abnormality of globe location"></display>
      <definition value="An abnormality in the placement of the ocular globe (eyeball)."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of eyeball position"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of globe position"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of eyeball location"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0012374"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0012374"></code>
      <display value="Abnormal globe morphology"></display>
      <definition value="An anomaly of the eyeball."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of the globe"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0012372"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040279"></code>
      <display value="Frequency"></display>
      <definition value="Class to represent frequency of phenotypic abnormalities within a patient cohort."></definition>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000001"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0100887"></code>
      <display value="Abnormality of globe size"></display>
      <definition value="An abnormality in the size of the ocular globe (eyeball)."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Eye size difference"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of eyeball size"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0012374"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000528"></code>
      <display value="Anophthalmia"></display>
      <definition value="Absence of the globe or eyeball."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="No globe of eye"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Clinical anophthalmia, unilateral/bilateral"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Absence of eyeballs"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Missing eyeball"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Missing globe of eye"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Absence of globes of eyes"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Ocular absence"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="No eyeball"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Anophthalmia, clinical"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Failure of development of eyeball"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0100887"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0040285"></code>
      <display value="Excluded"></display>
      <definition value="Present in 0% of the cases."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Excluded (0%)"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0040279"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0012372"></code>
      <display value="Abnormal eye morphology"></display>
      <definition value="A structural anomaly of the eye."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormal eye morphology"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormally shaped eye"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000478"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0012373"></code>
      <display value="Abnormal eye physiology"></display>
      <definition value="A functional anomaly of the eye."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormal eye physiology"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000478"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000118"></code>
      <display value="Phenotypic abnormality"></display>
      <definition value="A phenotypic abnormality."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Organ abnormality"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000001"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000007"></code>
      <display value="Autosomal recessive inheritance"></display>
      <definition value="A mode of inheritance that is observed for traits related to a gene encoded on one of the autosomes (i.e., the human chromosomes 1-22) in which a trait manifests in homozygotes. In the context of medical genetics, autosomal recessive disorders manifest in homozygotes (with two copies of the mutant allele) or compound heterozygotes (whereby each copy of a gene has a distinct mutant allele)."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal recessive predisposition"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal recessive"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal recessive form"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000005"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000568"></code>
      <display value="Microphthalmia"></display>
      <definition value="A developmental anomaly characterized by abnormal smallness of one or both eyes."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Nanophthalmos"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormally small globe of eye"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Decreased size of eyeball"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormally small eyeball"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Microphthalmos"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Decreased size of globe of eye"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0100887"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0007686"></code>
      <display value="Abnormal pupillary function"></display>
      <definition value="A functional abnormality of the pupil."></definition>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0012373"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000006"></code>
      <display value="Autosomal dominant inheritance"></display>
      <definition value="A mode of inheritance that is observed for traits related to a gene encoded on one of the autosomes (i.e., the human chromosomes 1-22) in which a trait manifests in heterozygotes. In the context of medical genetics, an autosomal dominant disorder is caused when a single copy of the mutant allele is present. Males and females are affected equally, and can both transmit the disorder with a risk of 50% for each child of inheriting the mutant allele."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal dominant type"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal dominant"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Autosomal dominant form"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000005"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000478"></code>
      <display value="Abnormality of the eye"></display>
      <definition value="Any abnormality of the eye, including location, spacing, and intraocular abnormalities."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of the eye"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormal eye"></value>
      </designation>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Eye disease"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000118"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000632"></code>
      <display value="Lacrimation abnormality"></display>
      <definition value="Abnormality of tear production."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Abnormality of tear production"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0012373"></valueCode>
      </property>
    </concept>
    <concept>
      <code value="HP:0000005"></code>
      <display value="Mode of inheritance"></display>
      <definition value="The pattern in which a particular genetic trait or disorder is passed from one generation to the next."></definition>
      <designation>
         <use>
            <system value="http://snomed.info/sct"></system>
            <code value="900000000000013009"></code>
            <display value="Synonym (core metadata concept)"></display>
         </use>
         <value value="Inheritance"></value>
      </designation>
      <property>
         <code value="parent"></code>
         <valueCode value="HP:0000001"></valueCode>
      </property>
    </concept>
  </CodeSystem>