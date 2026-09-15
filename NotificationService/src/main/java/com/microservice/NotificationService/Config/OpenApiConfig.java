package com.microservice.NotificationService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI NotificationServiceOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Notification Service API")
                .version("1.0.0")
                .description("Consumes order events and dispatches notifications"));
    }
}