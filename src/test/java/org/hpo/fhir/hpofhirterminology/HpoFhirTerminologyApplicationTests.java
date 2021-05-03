package org.hpo.fhir.hpofhirterminology;

import org.hpo.fhir.hpofhirterminology.fhir.IFhirService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.monarchinitiative.phenol.io.OntologyLoader;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HpoFhirTerminologyApplicationTests {

	@Autowired
	private IFhirService fhirService;

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void OntologyFHIRCodeSystemTestCreateCodeSystemXML(@TempDir Path temp) throws IOException {
		Ontology ontology = OntologyLoader.loadOntology(Paths.get("src/test/resources/hp_head.obo").toFile());
		File tempDirectory = temp.toFile();
		String tempFilePath = tempDirectory.getAbsolutePath() + File.separator +  "temp.xml";
		fhirService.writeCodeSystem(ontology, tempFilePath, "XML");
		try (BufferedReader br = new BufferedReader(new FileReader(tempFilePath))) {
			String line;
			while ((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	@Test
	public void OntologyFHIRCodeSystemTestCreateCodeSystemJSON(@TempDir Path temp) throws IOException {
		Ontology ontology = OntologyLoader.loadOntology(Paths.get("src/test/resources/hp_head.obo").toFile());
		File tempDirectory = temp.toFile();
		String tempFilePath = tempDirectory.getAbsolutePath() + File.separator +  "temp.json";
		fhirService.writeCodeSystem(ontology, tempFilePath, "JSON");
		try (BufferedReader br = new BufferedReader(new FileReader(tempFilePath))) {
			String line;
			while ((line=br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}



	}
