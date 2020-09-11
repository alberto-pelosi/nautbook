package com.codermine.cookbook;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
        info = @Info(
                title = "cookbook",
                version = "0.0",
                description = "Cookbook",
                license = @License(name = "WTFPL", url = "https://www.codermine.com/"),
                contact = @Contact(url = "https://contact-url.com", name = "Micronaut Supporter", email = "helpdesk@mail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
