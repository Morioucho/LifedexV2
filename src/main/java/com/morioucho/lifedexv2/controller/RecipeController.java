package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Recipe;
import com.morioucho.lifedexv2.service.RecipeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        List<Recipe> found = recipeService.getAllRecipes();
        model.addAttribute("recipes", found);

        return "recipe";
    }

    @GetMapping("/{id}")
    public String getRecipeByID(@PathVariable Long id, Model model) {
        Recipe found = recipeService.findByID(id);

        if(found != null) {
            model.addAttribute("recipe", found);
            return "recipe";
        }

        return "redirect:/error";
    }

    @PostMapping("/new")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        if (recipe.getTitle() == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(recipeService.createRecipe(recipe), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        if (recipeService.findByID(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        recipeService.deleteRecipe(id);
        return new ResponseEntity<>("Successfully deleted the Recipe with ID " + id + ".", HttpStatus.OK);
    }
}
