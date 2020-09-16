package com.codermine.cookbook.repository;

import com.codermine.cookbook.model.Recipe;
import com.codermine.cookbook.support.PersistenceTestSupport;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

@MicronautTest
class RecipeRepositoryTest {

    private static final String INSERT_RECIPE = "insert into recipe (id, name, description) OVERRIDING SYSTEM VALUE values (1, 'lol', 'desc');";

    private static final String INSERT_INGREDIENT_PASTA = "insert into ingredient (id, name, description) OVERRIDING SYSTEM VALUE values(1, 'pasta','pasta');";
    private static final String INSERT_INGREDIENT_TOMATO = "insert into ingredient (id, name, description) OVERRIDING SYSTEM VALUE values(2, 'pomodoro','pomodoro');";

    private static final String INSERT_RECIPE_INGREDIENT_PASTA = "insert into recipe_ingredient(recipe_id,ingredient_id, quantity, unit_of_measure) OVERRIDING SYSTEM VALUE values(1,1,6, 'GRAM');";
    private static final String INSERT_RECIPE_INGREDIENT_TOMATO = "insert into recipe_ingredient(recipe_id,ingredient_id, quantity, unit_of_measure)OVERRIDING SYSTEM VALUE values(1,2,9,'GRAM');";

    @Inject
    private RecipeRepository recipeRepository;

    @Inject
    private PersistenceTestSupport support;

    @BeforeEach
    public void init() {
        support.executeStatement(INSERT_RECIPE);
        support.executeStatement(INSERT_INGREDIENT_PASTA);
        support.executeStatement(INSERT_INGREDIENT_TOMATO);
        support.executeStatement(INSERT_RECIPE_INGREDIENT_PASTA);
        support.executeStatement(INSERT_RECIPE_INGREDIENT_TOMATO);
    }

    @Test
    void findByIdTest() {
        Optional<Recipe> recipe = recipeRepository.findById(1L);
        Assertions.assertTrue(recipe.isPresent());
        Assertions.assertNotNull(recipe.get().getDoses());
        Assertions.assertEquals(2, recipe.get().getDoses().size());
    }
}
