package com.prueba.prueba.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@Configuration
@ComponentScan({"com.prueba.prueba.controller"})
@OpenAPIDefinition(
    info = @Info(
        title = "API prueba de Manuel Figueiras Gago",
        version = "0.0.1",
        description ="API para la validación técnica de Manuel Figueiras Gago"
    
    )
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customOpenApi() {
        return GroupedOpenApi.builder().group("operativa").pathsToMatch("/operativa/**").build();
    }
}
