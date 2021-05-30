package com.mobiquity.core.services.impl;

import com.mobiquity.core.services.ApiRequest;
import com.mobiquity.core.services.ApiResponse;
import com.mobiquity.core.services.ApiService;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class RestApiService implements ApiService {

    @Override
    public ApiResponse get(ApiRequest request) {
        Response response = given()
                .queryParams(request.getParameters())
                .get(request.getUrl());
        return ApiResponse.builder()
                .payload(response.getBody().prettyPrint())
                .build();
    }
}
