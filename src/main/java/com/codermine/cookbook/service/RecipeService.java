package com.codermine.cookbook.service;

import com.codermine.cookbook.exception.CookbookException;
import com.codermine.cookbook.model.Recipe;
import com.codermine.cookbook.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class RecipeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private RecipeRepository recipeRepository;

    public Optional<Recipe> findById(Long id) {
        logger.info("RecipeService - findById - start - id: {}", id);
        Optional<Recipe> recipe = recipeRepository.findById(id);
        logger.info("RecipeService - findById - stop - recipe: {}", recipe);
        return recipe;
    }

    public Recipe insertRecipe(Recipe recipe) {
        logger.info("RecipeService - insertRecipe - start - recipe: {}", recipe);
        if(isPresent(recipe)) throw new CookbookException("Recipe already present");
        Recipe saveRecipe = recipeRepository.save(recipe);
        logger.info("RecipeService - insertRecipe - stop - recipe: {}", saveRecipe);
        return saveRecipe;
    }

    private boolean isPresent(Recipe recipe) {
        return !recipeRepository.findByName(recipe.getName()).isEmpty();
    }
}
