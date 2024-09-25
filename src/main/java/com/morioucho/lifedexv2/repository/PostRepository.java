package com.morioucho.lifedexv2.repository;

import com.morioucho.lifedexv2.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
