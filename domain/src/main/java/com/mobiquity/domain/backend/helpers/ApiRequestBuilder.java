package com.mobiquity.domain.backend.helpers;

import com.mobiquity.core.services.ApiRequest;
import com.mobiquity.domain.backend.configuration.JsonplaceholderApiProperties;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class ApiRequestBuilder {

    protected final JsonplaceholderApiProperties apiProperties;

    public ApiRequestBuilder(JsonplaceholderApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @SafeVarargs
    public final ApiRequest buildApiRequest(JsonplaceholderApiEndpoints endpoint, Pair<JsonplaceholderApiQueryParams, String>... params) {
        return ApiRequest.builder()
                .url(buildUrl(endpoint))
                .parameters(new HashMap<>() {{
                    Arrays.stream(params).forEach(param -> put(param.getKey().getParam(), param.getValue()));
                }})
                .build();
    }

    private String buildUrl(JsonplaceholderApiEndpoints endpoint) {
        return apiProperties.getBaseUrl() + apiProperties.getEndpoints().get(endpoint);
    }
}
