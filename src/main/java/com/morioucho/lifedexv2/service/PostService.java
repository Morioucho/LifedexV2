package com.morioucho.lifedexv2.service;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.repository.PostRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findByID(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post){
        post.setCreationDate(LocalDateTime.now());

        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public void saveAll(List<Post> posts){
        postRepository.saveAll(posts);
    }
}
