# pyrophen
Pyrophen generates a FHIR Code system representing the Human Phenotype Ontology

# Requirements
To build the app as described below, 
[maven](https://www.apache.org/>) and 
[docker](https://docs.docker.com/) as well as Java (at least version 11) must
be installed on your system.

# Getting Started

### Running the app

To run the app directly from maven, enter the following

```mermaid
 ./mvnw spring-boot:run -Dspring-boot.run.arguments=--hpo=/your/path/hp.obo 
```

### Building the app

To build a standalone app, enter
```mermaid
mvn package
```
This will build an executable file called ``pyrophen.jar`` in the ``target`` subdirectory.
Use the following command to see if you build was successful
```mermaid
$ java -jar target/pyrophen.jar
2021-04-17 12:55:50.287  INFO 31254 --- [           main] o.s.nativex.NativeListener               : This application is bootstrapped with code generated with Spring AOT

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

2021-04-17 12:55:50.386  INFO 31254 --- [           main] org.hpo.fhir.hpofhirterminology.CliMain  : Starting CliMain v0.0.1-SNAPSHOT using Java 14.0.1 on MLI-Robinson with PID 31254 (/Users/robinp/IdeaProjects/pyrophen/target/pyrophen.jar started by robinp in /Users/robinp/IdeaProjects/pyrophen)
2021-04-17 12:55:50.387  INFO 31254 --- [           main] org.hpo.fhir.hpofhirterminology.CliMain  : No active profile set, falling back to default profiles: default
2021-04-17 12:55:51.145  INFO 31254 --- [           main] org.hpo.fhir.hpofhirterminology.CliMain  : Started CliMain in 1.219 seconds (JVM running for 1.815)
Missing required option: '--hpo=<pathToHpo>'
Usage: fhir --hpo=<pathToHpo> [--out=<outfileName>]
      --hpo=<pathToHpo>     path to HPO obo file
      --out=<outfileName>   name/path of outfile
```
