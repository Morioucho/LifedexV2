package com.morioucho.lifedexv2.util;

import com.morioucho.lifedexv2.service.PostService;
import com.morioucho.lifedexv2.service.RecipeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderRunner implements CommandLineRunner {
    private final PostService postService;
    private final RecipeService recipeService;

    public DataLoaderRunner(PostService postService, RecipeService recipeService) {
        this.postService = postService;
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        DataLoader dataLoader = new DataLoader();

        postService.saveAll(dataLoader.listPosts());
        recipeService.saveAll(dataLoader.listRecipes());
    }
}
