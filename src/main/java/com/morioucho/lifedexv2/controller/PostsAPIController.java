package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.service.PostService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(("/api/posts"))
public class PostsAPIController {
    private final PostService postService;

    public PostsAPIController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        if (post.getTitle() == null || post.getContent() == null) {
            log.error("The given post was missing a crucial element.");

            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        Post foundPost = postService.findByID(id);

        if(foundPost != null){
            postService.deletePost(id);

            return new ResponseEntity<>("The post with ID " + id + "was successfully deleted.", HttpStatus.OK);
        }

        log.error("The post with ID {} was not found.", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
