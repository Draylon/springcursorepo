package com.stonks.StonksArt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:META-INF/v1_StonksArt.properties")
public class SwaggerConfig {
    private static final String BASE_PATH_APP = "/StonksArt";
    private static final String BASE_PATH_REST = "/api/";
    private static final String BASE_PACKAGE = "com.stonks.StonksArt.api";

    @Bean
    public Docket apis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stonks.StonksArt"))
                .paths(PathSelectors.any())
                .build();
    }
}
