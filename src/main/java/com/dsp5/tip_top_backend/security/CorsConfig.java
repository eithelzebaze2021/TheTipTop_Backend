package com.dsp5.tip_top_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET","PUT","DELETE","POST","OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("Access-Control-Expose-Headers")
                        .exposedHeaders("*")
                        .allowedOrigins("http://localhost:4200","https://tiptopgrp1.azurewebsites.net","https://dsp-archiwebf22-ez-af-sd.fr");
            }
        };
    }


}
