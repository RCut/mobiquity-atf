package com.mobiquity.domain.backend.actions;

import com.mobiquity.domain.backend.model.Comment;
import com.mobiquity.domain.backend.model.Post;
import com.mobiquity.domain.backend.model.User;

import java.util.List;

public interface JsonplaceholderApiActions {

    List<User> getUsers();

    List<User> getUsersByUsername(String username);

    String getUserIdByUsername(String username);

    List<Post> getPosts();

    List<Post> getPostsByUserId(String userId);

    List<Comment> getComments();

    List<Comment> getCommentsByPostId(String postId);

}
