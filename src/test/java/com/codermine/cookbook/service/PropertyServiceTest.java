package com.codermine.cookbook.service;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class PropertyServiceTest {

    @Inject
    private PropertyService propertyService;


    @Test
    void testExternalProperty() {
        Assertions.assertEquals("test-property-value", propertyService.getExternalProperty());
    }

    @Test
    void testTypeSafeProperties() {
        Assertions.assertEquals(42L, propertyService.getTypeSafeProperties().getId());
    }
}
