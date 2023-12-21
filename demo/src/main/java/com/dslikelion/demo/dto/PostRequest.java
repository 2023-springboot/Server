package com.dslikelion.demo.dto;

import com.dslikelion.demo.domain.Post;

public record PostRequest(
        String nickname,
        String content,
        boolean past
) {

    public static PostRequest of(Post post) {
        return new PostRequest(
                post.getNickname(),
                post.getContent(),
                post.isPast()
        );
    }
}
