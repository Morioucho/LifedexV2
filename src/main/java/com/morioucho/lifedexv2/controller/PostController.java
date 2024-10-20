package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping
    public String getAllPosts(Model model){
        List<Post> found = postService.findAll();
        model.addAttribute("posts", found);

        return "posts";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostByID(@PathVariable Long id){
        Post foundPost = postService.findByID(id);
        if(foundPost == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foundPost, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        if (post.getTitle() == null || post.getContent() == null) {
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

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
