package com.auto_prime.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Cors {

    @Configuration
    public class CorsConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")   // todos os endpoints
                            .allowedOrigins("*") // libera qualquer domínio
                            .allowedMethods("GET", "POST", "PUT", "DELETE"); // métodos permitidos
                }
            };
        }
    }
}
