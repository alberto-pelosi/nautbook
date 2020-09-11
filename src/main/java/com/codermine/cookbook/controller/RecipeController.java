package com.codermine.cookbook.controller;

import com.codermine.cookbook.model.Recipe;
import com.codermine.cookbook.service.RecipeService;
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

import static com.codermine.cookbook.controller.RecipeController.RECIPE_ENDPOINT;

@Controller(RECIPE_ENDPOINT)
@Tag(name = "Recipes", description = "Endpoint for Recipes management")
public class RecipeController {

    public static final String RECIPE_ENDPOINT = "/recipes";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private RecipeService recipeService;

    @Get(uri = "/{id}")
    @Operation(summary = "Get a Recipe",
            description = "Get a Recipe by Id"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "200", description = "Ok")
    public Recipe get(@PathVariable Long id) {
        logger.debug("RecipeController - get - start - id: {}", id);
        Recipe recipe = recipeService.findById(id).orElse(null);
        logger.debug("RecipeController - get - stop - recipe: {}", recipe);
        return recipe;
    }

    @Post
    @Operation(summary = "Insert a Recipe", description = "Insert a Recipe.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public Recipe post(Recipe recipe) {
        logger.debug("RecipeController - post - start - recipe: {}", recipe);
        Recipe savedRecipe = recipeService.insertRecipe(recipe);
        logger.debug("RecipeController - get - stop - savedRecipe: {}", savedRecipe);
        return savedRecipe;
    }
}
