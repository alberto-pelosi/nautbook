package com.codermine.cookbook.model;



import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@MappedEntity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "ingredient")
    private List<Dose> doses;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
