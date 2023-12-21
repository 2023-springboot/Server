package com.dslikelion.demo.repository;

import com.dslikelion.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findByPastIsTrue();
    List<Post> findByPastIsFalse();

}
