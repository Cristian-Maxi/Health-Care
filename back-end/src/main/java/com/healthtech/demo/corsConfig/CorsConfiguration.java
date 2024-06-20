package com.healthtech.demo.corsConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173", "https://tu-dominio-de-produccion.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "X-XSRF-TOKEN", "Authorization")
                .allowCredentials(true);
        System.out.println("CORS configuration applied successfully.");
    }
}