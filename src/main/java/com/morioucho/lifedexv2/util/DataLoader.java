package com.morioucho.lifedexv2.util;

import com.morioucho.lifedexv2.model.Post;
import com.morioucho.lifedexv2.model.Recipe;
import com.morioucho.lifedexv2.model.ViewStatistic;

import lombok.extern.slf4j.Slf4j;

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
        String[] postStrings = {
                "Post Title 1,This is the content of post 1,John,Doe",
                "Post Title 2,This is the content of post 2,Jane,Smith",
                "Post Title 3,This is the content of post 3,Bob,Brown"
        };

        for (String postString : postStrings) {
            String[] fields = postString.split(",");

            if (fields.length < 4) {
                log.error("One of the lines doesn't contain enough details.");
                continue;
            }

            Post post = new Post();
            post.setViewStatistic(new ViewStatistic());
            post.setTitle(fields[0]);
            post.setContent(fields[1]);
            post.setAuthorFirst(fields[2]);
            post.setAuthorLast(fields[3]);

            posts.add(post);
        }
    }

    private void loadRecipes() {
        String[] recipeStrings = {
                "Recipe Title 1,Description of recipe 1,Chef A,LastName A,Step 1; Step 2; Step 3,30,200,Italian,4",
                "Recipe Title 2,Description of recipe 2,Chef B,LastName B,Step 1; Step 2; Step 3,45,300,Mexican,2",
                "Recipe Title 3,Description of recipe 3,Chef C,LastName C,Step 1; Step 2; Step 3,60,150,Indian,3"
        };

        for (String recipeString : recipeStrings) {
            String[] fields = recipeString.split(",");

            if (fields.length < 9) {
                log.error("One of the lines does not contain enough details.");
                continue;
            }

            Recipe recipe = new Recipe();
            recipe.setViewStatistic(new ViewStatistic());
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

    public List<Post> listPosts() {
        return posts;
    }

    public List<Recipe> listRecipes() {
        return recipes;
    }
}
