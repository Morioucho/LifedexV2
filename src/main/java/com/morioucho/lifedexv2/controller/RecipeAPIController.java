package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Recipe;
import com.morioucho.lifedexv2.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/recipes")
public class RecipeAPIController {
    private final RecipeService recipeService;

    public RecipeAPIController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        if (recipe.getTitle() == null) {
            log.error("The given recipe was missing a crucial element.");

            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(recipeService.createRecipe(recipe), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllPosts() {
        List<Recipe> recipies = new ArrayList<>();
        recipies = recipeService.getAllRecipes();

        if(recipies.isEmpty()){
            return new ResponseEntity<>(recipies, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findRecipe(@PathVariable long id){
        Recipe found = recipeService.findByID(id);

        if(found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        if (recipeService.findByID(id) == null) {
            log.error("The post with ID {} was not found.", id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        recipeService.deleteRecipe(id);
        return new ResponseEntity<>("Successfully deleted the Recipe with ID " + id + ".", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> lookupRecipe(@RequestParam String query) {
        List<Recipe> relevantRecipes = new ArrayList<>();

        for(Recipe recipe : recipeService.getAllRecipes()) {
            if (recipe.getTitle().toLowerCase().contains(query.toLowerCase())) {
                relevantRecipes.add(recipe);
            }
        }

        return new ResponseEntity<>(relevantRecipes, HttpStatus.OK);
    }
}
