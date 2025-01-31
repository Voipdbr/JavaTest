package com.sigabem.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sigabem"))
                .paths(regex("/sigabem-api.*"))
                .build()
                .apiInfo(info());
    }

    private ApiInfo info() {

        ApiInfo apiInfo = new ApiInfo(
                "API de consulta simples",
                "Trata-se de uma API Simples na qual o cliente fará uma consulta do valor total do frete ao qual seu CEP de origem pode ou não aplicar, com desconto na consulta do CEP de destino.",
                "1.0",
                "Terms of Service",
                new Contact("Ismael José", "https://ismaeljose.site",
                        ""),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
    
}
