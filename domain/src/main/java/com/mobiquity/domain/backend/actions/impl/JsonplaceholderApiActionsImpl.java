package com.mobiquity.domain.backend.actions.impl;

import com.mobiquity.core.services.ApiResponse;
import com.mobiquity.core.services.ApiService;
import com.mobiquity.domain.backend.actions.JsonplaceholderApiActions;
import com.mobiquity.domain.backend.helpers.ApiRequestBuilder;
import com.mobiquity.domain.backend.helpers.JsonHelper;
import com.mobiquity.domain.backend.model.Comment;
import com.mobiquity.domain.backend.model.Post;
import com.mobiquity.domain.backend.model.User;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.COMMENTS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.POSTS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiEndpoints.USERS;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.POST_ID;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.USERNAME;
import static com.mobiquity.domain.backend.helpers.JsonplaceholderApiQueryParams.USER_ID;

@Service
public class JsonplaceholderApiActionsImpl implements JsonplaceholderApiActions {

    private final JsonHelper jsonHelper;
    private final ApiService apiService;
    private final ApiRequestBuilder apiRequestBuilder;

    public JsonplaceholderApiActionsImpl(JsonHelper jsonHelper, ApiService apiService, ApiRequestBuilder apiRequestBuilder) {
        this.jsonHelper = jsonHelper;
        this.apiService = apiService;
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Override
    public List<User> getUsers() {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(USERS));
        User[] users = jsonHelper.fromJson(response.getPayload(), User[].class);
        return Arrays.stream(users).toList();
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(USERS, Pair.of(USERNAME, username)));
        User[] users = jsonHelper.fromJson(response.getPayload(), User[].class);
        return Arrays.stream(users).toList();
    }

    @Override
    public String getUserIdByUsername(String username) {
        Optional<User> user = getUsersByUsername(username).stream().findFirst();
        if (user.isEmpty())
            throw new RuntimeException("User '" + username + "' not found");
        return user.get().getId();
    }

    @Override
    public List<Post> getPosts() {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(POSTS));
        Post[] posts = jsonHelper.fromJson(response.getPayload(), Post[].class);
        return Arrays.stream(posts).toList();
    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(POSTS, Pair.of(USER_ID, userId)));
        Post[] posts = jsonHelper.fromJson(response.getPayload(), Post[].class);
        return Arrays.stream(posts).toList();
    }

    @Override
    public List<Comment> getComments() {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(COMMENTS));
        Comment[] comments = jsonHelper.fromJson(response.getPayload(), Comment[].class);
        return Arrays.stream(comments).toList();
    }

    @Override
    public List<Comment> getCommentsByPostId(String postId) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildApiRequest(COMMENTS, Pair.of(POST_ID, postId)));
        Comment[] comments = jsonHelper.fromJson(response.getPayload(), Comment[].class);
        return Arrays.stream(comments).toList();
    }
}
