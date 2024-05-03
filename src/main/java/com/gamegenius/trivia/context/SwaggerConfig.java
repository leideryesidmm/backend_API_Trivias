package com.gamegenius.trivia.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gamegenius.trivia.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "TriviatonAPI",
                "La API rest de Triviaton",
                "v1",
                "Terms of service",
                new Contact("GameGenius", "www.example.com", "leideryesidmm@gmail.com"),
                "CLOSET", "API license URL", Collections.emptyList());
    }
}
