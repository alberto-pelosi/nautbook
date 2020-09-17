package com.codermine.cookbook.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("config.properties")
public class TypeSafeProperties {


    private Long id = -1L;

    @NotEmpty
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
}
