package com.codermine.cookbook.repository;

import com.codermine.cookbook.model.Dose;
import com.codermine.cookbook.model.Ingredient;
import com.codermine.cookbook.model.Recipe;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class DoseRepository implements CrudRepository<Dose, Long> {

    public abstract List<Dose> findByRecipe(Recipe recipe);

    public abstract List<Dose> findByIngredient(Ingredient ingredient);
}
