package com.mobiquity.domain.backend.configuration;

import com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("backend.jsonplaceholder")
public class JsonplaceholderApiProperties {

    private String baseUrl;
    private Map<JsonplaceholderApiEndpoints, String> endpoints;
}
