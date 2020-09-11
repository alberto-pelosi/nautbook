package com.codermine.cookbook.repository;

import com.codermine.cookbook.model.Recipe;
import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class RecipeRepository implements CrudRepository<Recipe, Long> {


    @NonNull
    @Join(value = "doses", type = Join.Type.LEFT_FETCH)
    @Join(value = "doses.ingredient", type = Join.Type.LEFT_FETCH)
    public abstract Optional<Recipe> findById(@NotNull @NonNull Long id);

    public abstract List<Recipe> findByName(String name);
}
