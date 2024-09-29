package com.morioucho.lifedexv2.service;

import com.morioucho.lifedexv2.model.Recipe;
import com.morioucho.lifedexv2.repository.RecipeRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe findByID(Long id){
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe createRecipe(Recipe recipe){
        recipe.setCreationDate(LocalDateTime.now());

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }
}
