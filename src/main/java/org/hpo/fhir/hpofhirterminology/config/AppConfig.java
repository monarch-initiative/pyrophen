package org.hpo.fhir.hpofhirterminology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="codeSystemUri")
    public String codeSystemUri() {
        return "http://purl.obolibrary.org/obo/hp.fhir";
    }

}
