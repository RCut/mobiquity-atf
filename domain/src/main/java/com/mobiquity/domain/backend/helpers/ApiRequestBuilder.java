package com.mobiquity.domain.backend.helpers;

import com.mobiquity.core.services.ApiRequest;
import com.mobiquity.domain.backend.configuration.JsonplaceholderApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.COMMENTS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.POSTS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.USERS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.POST_ID;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.USERNAME;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.USER_ID;

@Service
public class ApiRequestBuilder {

    @Autowired
    protected JsonplaceholderApiProperties apiProperties;

    public ApiRequest buildGetUsersRequest() {
        return ApiRequest.builder()
                .url(buildUrl(USERS))
                .build();
    }

    public ApiRequest buildGetUsersByUsernameRequest(String username) {
        return ApiRequest.builder()
                .url(buildUrl(USERS))
                .parameters(new HashMap<>() {{
                    put(USERNAME.getParam(), username);
                }})
                .build();
    }

    public ApiRequest buildGetPostsRequest() {
        return ApiRequest.builder()
                .url(buildUrl(POSTS))
                .build();
    }

    public ApiRequest buildGetPostsByUserIdRequest(String userId) {
        return ApiRequest.builder()
                .url(buildUrl(POSTS))
                .parameters(new HashMap<>() {{
                    put(USER_ID.getParam(), userId);
                }})
                .build();
    }

    public ApiRequest buildGetCommentsRequest() {
        return ApiRequest.builder()
                .url(buildUrl(COMMENTS))
                .build();
    }

    public ApiRequest buildGetCommentsByPostIdRequest(String postId) {
        return ApiRequest.builder()
                .url(buildUrl(COMMENTS))
                .parameters(new HashMap<>() {{
                    put(POST_ID.getParam(), postId);
                }})
                .build();
    }

    private String buildUrl(JsonplaceholderApiEndpoints endpoint) {
        return apiProperties.getBaseUrl() + apiProperties.getEndpoints().get(endpoint.asLowerCase());
    }
}
