package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.service.PostService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }


    @GetMapping
    public String getAllPosts(Model model){
        List<Post> found = postService.findAll();
        model.addAttribute("posts", found);

        return "post";
    }

    @GetMapping("/{id}")
    public String getPostByID(@PathVariable Long id, Model model) {
        Post found = postService.findByID(id);

        if(found != null) {
            model.addAttribute("post", found);
            return "post";
        }

        log.error("Unable to find a post with ID {}.", id);
        return "redirect:/error";
    }
}
