package com.codermine.cookbook.service;

import com.codermine.cookbook.exception.CookbookException;
import com.codermine.cookbook.model.Ingredient;
import com.codermine.cookbook.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

@Singleton
public class IngredientService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private IngredientRepository ingredientRepository;

    public Optional<Ingredient> findById(@PositiveOrZero Long id) {
        logger.info("IngredientService - findById - start - id: {}", id);
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        logger.info("IngredientService - findById - stop - ingredient: {}", ingredient);
        return ingredient;
    }

    public Ingredient insertIngredient(@NotNull @Valid Ingredient ingredient) {
        logger.info("IngredientService - insertIngredient - start - ingredient: {}", ingredient);
        if(isPresent(ingredient)) throw new CookbookException("Recipe already present");
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        logger.info("IngredientService - insertIngredient - stop - ingredient: {}", savedIngredient);
        return savedIngredient;
    }

    private boolean isPresent(@NotNull @Valid Ingredient ingredient) {
        return !ingredientRepository.findByName(ingredient.getName()).isEmpty();
    }
}
