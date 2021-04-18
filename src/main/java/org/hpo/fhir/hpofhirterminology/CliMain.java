package org.hpo.fhir.hpofhirterminology;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;


/**
 * Main entry point for the pyrophen application that takes as input the path to the hp.obo file
 * and outputs the corresponding FHIR codesystem.
 */
@SpringBootApplication
public class CliMain implements CommandLineRunner, ExitCodeGenerator {
    private final CommandLine.IFactory factory;
    private int exitCode;
    private final HpoFhirCommand hpoFhirCommand;

    public CliMain(CommandLine.IFactory iFactory, HpoFhirCommand command) {
        this.factory = iFactory;
        this.hpoFhirCommand = command;
    }

    @Override
    public void run(String... args) {
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
