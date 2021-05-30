package com.mobiquity.core.services;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ApiRequest {

    private String url;
    @Builder.Default
    private Map<String, String> parameters = new HashMap<>();
}
