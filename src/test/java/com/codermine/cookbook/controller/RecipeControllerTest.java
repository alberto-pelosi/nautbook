package com.codermine.cookbook.controller;

import com.codermine.cookbook.model.Recipe;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.codermine.cookbook.controller.RecipeController.RECIPE_ENDPOINT;

@MicronautTest
public class RecipeControllerTest {

    @Client("/")
    @Inject
    HttpClient httpClient;

    @Test
    void postTest() {
        Recipe recipe = new Recipe();
        recipe.setName("Pizza Margherita");
        recipe.setDescription("Pizza Margherita, ricetta di Cracco.");
        HttpRequest request = HttpRequest.POST(RECIPE_ENDPOINT, recipe);
        Recipe response = httpClient.toBlocking().retrieve(request, Recipe.class);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getId());
        Assertions.assertEquals("Pizza Margherita", response.getName());
        Assertions.assertEquals("Pizza Margherita, ricetta di Cracco.", response.getDescription());
    }
}
