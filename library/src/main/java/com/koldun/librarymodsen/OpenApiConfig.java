package com.koldun.librarymodsen;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Library Service Api",
                description = "Library Service", version = "0.1",
                contact = @Contact(
                        name = "name",
                        email = "email",
                        url = "url"
                )
        )
)

public class OpenApiConfig {
}
