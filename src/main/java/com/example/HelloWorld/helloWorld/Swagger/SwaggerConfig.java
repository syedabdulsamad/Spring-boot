package com.example.HelloWorld.helloWorld.Swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration

public class SwaggerConfig {





    final static Contact contact = new Contact("Syed Abdul Samad",
            "https://www.nordea.fi",
            "abdul.samad@nordea.com");

    final static ApiInfo apiInfo = new ApiInfo("User API",
            "Users API Info",
            "1.0",
            "https://www.nordea.fi",
            contact,
            "Test License",
            "https://www.nordea.fi/license",
            new ArrayList<VendorExtension>());

    @Bean
    public Docket api() {
        Set<String> produces = new HashSet<String>(Arrays.asList("JSON", "XML"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .produces(produces)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

}
