package com.example.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Health APP")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.myspringboot.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(appApiInfo());
    }

    private ApiInfo appApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Health APP SWAGGER  API",
                "Test REST API, all the applications could access the Object model data via JSON.",
                "1.0",
                "NO terms of service",
                "yishan Wang",
                "Health APP Backend",
                "http://my-spring-boot-env-2.eba-uzpmfwsg.us-east-2.elasticbeanstalk.com/index"
        );
        return apiInfo;
    }
}
