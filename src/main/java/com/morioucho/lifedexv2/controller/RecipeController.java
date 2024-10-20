package com.morioucho.lifedexv2.controller;

import com.morioucho.lifedexv2.model.Recipe;
import com.morioucho.lifedexv2.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(("/recipes"))
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

        log.error("Unable to find a recipe with ID {}.", id);
        return "redirect:/error";
    }
}
