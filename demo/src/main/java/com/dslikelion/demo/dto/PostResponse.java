package com.dslikelion.demo.dto;

import com.dslikelion.demo.domain.Post;

public record PostResponse(
        Long id,
        String nickname,
        String content,
        boolean past) {

    public static PostResponse of(Post post) {
        return new PostResponse(
                post.getId(),
                post.getNickname(),
                post.getContent(),
                post.isPast()
        );
    }
}
