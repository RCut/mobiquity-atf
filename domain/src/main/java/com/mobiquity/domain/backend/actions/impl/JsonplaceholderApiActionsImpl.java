package com.mobiquity.domain.backend.actions.impl;

import com.mobiquity.core.services.ApiResponse;
import com.mobiquity.core.services.ApiService;
import com.mobiquity.domain.backend.actions.JsonplaceholderApiActions;
import com.mobiquity.domain.backend.helpers.ApiRequestBuilder;
import com.mobiquity.domain.backend.helpers.JsonHelper;
import com.mobiquity.domain.backend.model.Comment;
import com.mobiquity.domain.backend.model.Post;
import com.mobiquity.domain.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JsonplaceholderApiActionsImpl implements JsonplaceholderApiActions {

    @Autowired
    protected JsonHelper jsonHelper;

    @Autowired
    protected ApiService apiService;

    @Autowired
    protected ApiRequestBuilder apiRequestBuilder;

    @Override
    public List<User> getUsers() {
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetUsersRequest());
        User[] users = jsonHelper.fromJson(response.getPayload(), User[].class);
        return Arrays.stream(users).toList();
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetUsersByUsernameRequest(username));
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
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetPostsRequest());
        Post[] posts = jsonHelper.fromJson(response.getPayload(), Post[].class);
        return Arrays.stream(posts).toList();
    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetPostsByUserIdRequest(userId));
        Post[] posts = jsonHelper.fromJson(response.getPayload(), Post[].class);
        return Arrays.stream(posts).toList();
    }

    @Override
    public List<Comment> getComments() {
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetCommentsRequest());
        Comment[] comments = jsonHelper.fromJson(response.getPayload(), Comment[].class);
        return Arrays.stream(comments).toList();
    }

    @Override
    public List<Comment> getCommentsByPostId(String postId) {
        ApiResponse response = apiService.get(apiRequestBuilder.buildGetCommentsByPostIdRequest(postId));
        Comment[] comments = jsonHelper.fromJson(response.getPayload(), Comment[].class);
        return Arrays.stream(comments).toList();
    }
}
