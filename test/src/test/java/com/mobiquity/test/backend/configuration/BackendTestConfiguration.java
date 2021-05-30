package com.mobiquity.test.backend.configuration;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@Data
@SpringBootConfiguration
@ComponentScan(basePackages = {
        "com.mobiquity.test.common",
        "com.mobiquity.test.backend",
        "com.mobiquity.domain.backend",
        "com.mobiquity.core.services",
})
@ConfigurationProperties("backend")
public class BackendTestConfiguration {

    private String baseUrl;

}
