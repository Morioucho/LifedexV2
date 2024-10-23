package com.morioucho.lifedexv2.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.model.Recipe;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DataLoader {
    private final List<Post> posts;
    private final List<Recipe> recipes;

    public DataLoader() {
        this.posts = new ArrayList<>();
        this.recipes = new ArrayList<>();
        loadPosts();
        loadRecipes();
    }

    private void loadPosts() {
        try {
            ClassPathResource resource = new ClassPathResource("data/posts.json");
            Reader reader = new InputStreamReader(resource.getInputStream());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            Type postListType = new TypeToken<List<Post>>() {}.getType();
            List<Post> postList = gson.fromJson(reader, postListType);
            posts.addAll(postList);

        } catch (Exception exception) {
            log.error("Error loading posts: " + exception.getMessage());
        }
    }

    private void loadRecipes() {
        try {
            ClassPathResource resource = new ClassPathResource("data/recipes.json");
            Reader reader = new InputStreamReader(resource.getInputStream());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            Type recipeListType = new TypeToken<List<Recipe>>() {}.getType();
            List<Recipe> recipeList = gson.fromJson(reader, recipeListType);
            recipes.addAll(recipeList);

        } catch (Exception exception) {
            log.error("Error loading recipes: {}", exception.getMessage());
        }
    }

    public List<Post> listPosts() {
        return posts;
    }

    public List<Recipe> listRecipes() {
        return recipes;
    }
}
