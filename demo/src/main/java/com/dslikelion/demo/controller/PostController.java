package com.dslikelion.demo.controller;

import com.dslikelion.demo.domain.BaseApiResponse;
import com.dslikelion.demo.dto.PostRequest;
import com.dslikelion.demo.dto.PostResponse;
import com.dslikelion.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public BaseApiResponse<PostRequest> createPost(@RequestBody PostRequest request) {
        return new BaseApiResponse<>("게시글 생성 완료", postService.create(request));
    }


    //    하나 조회
    @GetMapping("{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

//    올해
    @GetMapping("/listthis")
    public ResponseEntity<List<PostResponse>> getthisPosts() {
        return ResponseEntity.ok(postService.getthisPosts());
    }

//    내년
    @GetMapping("/listnext")
    public ResponseEntity<List<PostResponse>> getnextPosts() {
        return ResponseEntity.ok(postService.getnextPosts());
    }


}
