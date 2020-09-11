package com.codermine.cookbook.controller;

import com.codermine.cookbook.model.Ingredient;
import com.codermine.cookbook.service.IngredientService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


@Controller(IngredientController.INGREDIENT_ENDPOINT)
@Tag(name = "Ingredients", description = "Endpoint for Ingredients management")
public class IngredientController {

    public static final String INGREDIENT_ENDPOINT = "/ingredients";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private IngredientService ingredientService;

    @Get(uri = "/{id}")
    @Operation(summary = "Get an Ingredient",
            description = "Get an Ingredient by Id"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "200", description = "Ok")
    public Ingredient get(@PathVariable Long id) {
        logger.debug("IngredientController - get - start - id: {}", id);
        Ingredient ingredient = ingredientService.findById(id).orElse(null);
        logger.debug("IngredientController - get - stop - ingredient: {}", ingredient);
        return ingredient;
    }

    @Post
    @Operation(summary = "Insert an Ingredient", description = "Insert an Ingredient.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public Ingredient post(Ingredient ingredient) {
        logger.debug("IngredientController - post - start - ingredient: {}", ingredient);
        Ingredient savedIngredient = ingredientService.insertIngredient(ingredient);
        logger.debug("IngredientController - get - stop - savedIngredient: {}", savedIngredient);
        return savedIngredient;
    }
}

