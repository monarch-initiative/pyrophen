.. _rstrunning:

#############################
Building and Running pyrophen
#############################

pyrophen is a `Java  <https://www.java.com/en/>`_ application that can be built using Java version 11 or later.
pyrophen makes use of the `Spring <https://spring.io/>`_ framework. Additionally,
`maven <https://maven.apache.org/>`_ is required to build pyrophen.


Building pyrophen
#################

Clone pyrophen from its GitHub repository.

.. code-block:: bash

    git clone https://github.com/monarch-initiative/pyrophen

Alternatively, you can download the source code from the repository https://github.com/monarch-initiative/pyrophen.

Change into the directory and build.

.. code-block:: bash

    cd pyrophen
    mvn package

This will create an executable jar file in a subdirectory called ``target``. To test the build, run
the code without arguments. You should see something like the following.

.. code-block:: bash

    java -jar target/pyrophen.jar
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
    Usage: fhir [--format=<outputFormat>] --hpo=<pathToHpo> [--out=<outfileName>]
          --format=<outputFormat>
                                format of output file (json [default], xml)
          --hpo=<pathToHpo>     path to HPO json file
          --out=<outfileName>   name/path of outfile

Running pyrophen
################

To run pyrophen, you will need to have a copy of the ``hp.json`` file. The latest version
can be obtained from the
`HPO GitHub repository <https://github.com/obophenotype/human-phenotype-ontology>`_.

The ``pyrophen app gets the path to this file via the ``--hpo`` argument. Additionally, you can
set the name/path of the output XML file via the ``--out`` argument (the default is ``hp_fhir.json``).


.. code-block:: bash

    java -jar pyrophen.jar --hpo /some/path/hp.json [--out myxmlfile.json]



