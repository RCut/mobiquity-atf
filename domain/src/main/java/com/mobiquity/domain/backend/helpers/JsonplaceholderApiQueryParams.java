package com.mobiquity.domain.backend.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonplaceholderApiQueryParams {
    USERNAME("username"),
    USER_ID("userId"),
    POST_ID("postId");

    private final String param;
}
