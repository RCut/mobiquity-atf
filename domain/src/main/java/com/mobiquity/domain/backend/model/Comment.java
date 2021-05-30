package com.mobiquity.domain.backend.model;

import lombok.Data;

@Data
public class Comment {
    private String id;
    private String postId;
    private String email;
}
