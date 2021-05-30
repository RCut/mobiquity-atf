package com.mobiquity.domain.backend.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("backend.jsonplaceholder")
public class JsonplaceholderApiProperties {

    private String baseUrl;
    private Map<String, String> endpoints;
}
