package org.hpo.fhir.hpofhirterminology;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;



@SpringBootApplication
public class CliMain implements CommandLineRunner, ExitCodeGenerator {
    private final CommandLine.IFactory factory;
    private int exitCode;
    private HpoFhirCommand hpoFhirCommand;

    public CliMain(CommandLine.IFactory iFactory, HpoFhirCommand command) {
        this.factory = iFactory;
        this.hpoFhirCommand = command;
    }

    @Override
    public void run(String... args) throws Exception {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        //String  obj = (DemoManager) context.getBean("demoService");
//
//        Ontology hpo = OntologyLoader.loadOntology(Paths.get(args[0]).toFile());
//        OntologyFHIRCodeSystem ontologyFHIRCodeSystem = new OntologyFHIRCodeSystem("http://purl.obolibrary.org/obo/hp.fhir", hpo);
//        CodeSystem codeSystem = ontologyFHIRCodeSystem.ontologyToCodeSystem(hpo);
//        ontologyFHIRCodeSystem.writeCodeSystemXml(codeSystem, args[1]);
//        System.out.println("Written file " + args[1]);
        // let picocli parse command line args and run the business logic
        this.exitCode = new CommandLine(hpoFhirCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return this.exitCode;
    }

    public static void main(String[] args) {
        // let Spring instantiate and inject dependencies
        System.exit(SpringApplication.exit(SpringApplication.run(CliMain.class, args)));
    }
}
