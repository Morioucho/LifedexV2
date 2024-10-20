package com.morioucho.lifedexv2.util;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.model.Recipe;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DataLoader {
    private final String postsFilePath;
    private final String recipesFilePath;

    private final List<Post> posts;
    private final List<Recipe> recipes;

    public DataLoader(String postsFilePath, String recipesFilePath) {
        this.postsFilePath = postsFilePath;
        this.recipesFilePath = recipesFilePath;

        this.posts = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    public List<Post> listPosts(){
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(postsFilePath))){
                String line;

                while((line = br.readLine()) != null){
                    String[] fields = line.split(",");

                    if(fields.length < 3){
                        throw new Exception("One of the lines doesnt contain enough details.");
                    }

                    Post post = new Post();
                    post.setTitle(fields[0]);
                    post.setContent(fields[1]);
                    post.setAuthorFirst(fields[2]);
                    post.setAuthorLast(fields[3]);

                    posts.add(post);
                }
            }
        } catch(Exception ex){
            log.error(ex.getMessage());
        }

        return posts;
    }

    public List<Recipe> listRecipes(){
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(recipesFilePath))){
                String line;

                while((line = br.readLine()) != null){
                    String[] fields = line.split(",");

                    if(fields.length < 8){
                        throw new Exception("One of the lines does not contain enough details.");
                    }

                    Recipe recipe = new Recipe();
                    recipe.setTitle(fields[0]);
                    recipe.setContent(fields[1]);
                    recipe.setAuthorFirst(fields[2]);
                    recipe.setAuthorLast(fields[3]);
                    recipe.setSteps(fields[4]);
                    recipe.setCookTime(Integer.parseInt(fields[5]));
                    recipe.setCalories(Integer.parseInt(fields[6]));
                    recipe.setCuisine(fields[7]);
                    recipe.setYield(Integer.parseInt(fields[8]));

                    recipes.add(recipe);
                }
            }
        } catch(Exception ex){
            log.error(ex.getMessage());
        }

        return recipes;
    }
}
