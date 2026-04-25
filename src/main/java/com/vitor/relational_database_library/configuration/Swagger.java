package com.vitor.relational_database_library.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpemAPI(){

        return new OpenAPI().info(new Info()
                .title("Biblioteca")
                .version("1.0.0")
                .description("Documentação da Biblioteca API"));

    }
}
