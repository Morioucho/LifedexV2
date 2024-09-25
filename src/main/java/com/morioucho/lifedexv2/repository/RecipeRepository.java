package com.morioucho.lifedexv2.repository;

import com.morioucho.lifedexv2.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
