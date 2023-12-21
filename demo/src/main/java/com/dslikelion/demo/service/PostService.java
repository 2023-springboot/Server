package com.dslikelion.demo.service;


import com.dslikelion.demo.domain.Post;
import com.dslikelion.demo.dto.PostRequest;
import com.dslikelion.demo.dto.PostResponse;
import com.dslikelion.demo.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;

    @Transactional
    public PostRequest create(PostRequest request) {
        Post post = postJpaRepository.save(
                Post.builder()
                        .nickname(request.nickname())
                        .content(request.content())
                        .past(request.past())
                        .build()
        );

        return PostRequest.of(post);
    }

    public PostResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 게시글이 없습니다.")
        );
        return PostResponse.of(post);
    }

    public List<PostResponse> getthisPosts() {
        return postJpaRepository.findByPastIsTrue()
                .stream()
                .map(post -> PostResponse.of(post))
                .toList();
    }

    public List<PostResponse> getnextPosts() {
        return postJpaRepository.findByPastIsFalse()
                .stream()
                .map(post -> PostResponse.of(post))
                .toList();
    }

}
