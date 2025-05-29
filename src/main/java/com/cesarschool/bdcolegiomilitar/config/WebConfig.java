package com.cesarschool.bdcolegiomilitar.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
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
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> {
            // continua serializando em snake_case (p/ o GET)
            builder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            // mas aceita camelCase no JSON de entrada (p/ POST/PUT)
            builder.featuresToEnable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        };
    }
}
