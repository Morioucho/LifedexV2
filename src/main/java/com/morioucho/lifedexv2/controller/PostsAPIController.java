package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.service.PostService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        posts = postService.findAll();

        if(posts.isEmpty()){
            return new ResponseEntity<>(posts, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPost(@PathVariable long id){
        Post found = postService.findByID(id);

        if(found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(found, HttpStatus.OK);
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

    @GetMapping("/search")
    public ResponseEntity<List<Post>> lookupPost(@RequestParam String query) {
        List<Post> posts = new ArrayList<>();
        posts = postService.findAll();

        if(posts.isEmpty() || posts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        List<Post> relevantPosts = new ArrayList<>();
        for(Post p : posts) {
            if (p.getContent().contains(query)) {
                relevantPosts.add(p);
            }
        }
        return new ResponseEntity<>(relevantPosts, HttpStatus.OK);
    }
}
