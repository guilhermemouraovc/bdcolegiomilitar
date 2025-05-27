package com.cesarschool.bdcolegiomilitar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // libera todas as rotas
                .allowedOrigins("*") // libera todas as origens (não seguro em produção)
                .allowedMethods("*") // libera todos os métodos
                .allowedHeaders("*") // libera todos os headers
                .allowCredentials(false); // não permite cookies (opcional)
    }
}
