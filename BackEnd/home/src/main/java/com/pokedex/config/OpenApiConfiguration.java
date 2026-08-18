package com.pokedex.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
            title = "POKEDEX API",
            version = "v0.1",
            description = "An API that has a game inside"
        )
)

@Configuration
public class OpenApiConfiguration {
}
