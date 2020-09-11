package com.codermine.cookbook.repository;

import com.codermine.cookbook.model.Ingredient;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class IngredientRepository implements CrudRepository<Ingredient, Long> {

    public abstract List<Ingredient> findByName(String name);
}
