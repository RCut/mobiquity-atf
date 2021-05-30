package com.mobiquity.domain.backend.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonplaceholderApiEndpoints {
    USERS,
    POSTS,
    COMMENTS;

    public String asLowerCase(){
        return name().toLowerCase();
    }
}
