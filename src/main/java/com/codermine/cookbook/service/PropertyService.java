package com.codermine.cookbook.service;

import com.codermine.cookbook.configuration.TypeSafeProperties;
import io.micronaut.context.annotation.Value;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PropertyService {

    @Value("${my.prop:default-value}")
    private String externalProperty;

    @Inject
    private TypeSafeProperties typeSafeProperties;

    public String getExternalProperty() {
        return externalProperty;
    }

    public void setExternalProperty(String externalProperty) {
        this.externalProperty = externalProperty;
    }

    public TypeSafeProperties getTypeSafeProperties() {
        return typeSafeProperties;
    }

    public void setTypeSafeProperties(TypeSafeProperties typeSafeProperties) {
        this.typeSafeProperties = typeSafeProperties;
    }
}
