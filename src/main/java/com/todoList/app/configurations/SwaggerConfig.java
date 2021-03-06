package com.todoList.app.configurations;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.todoList.app.api"))
				.paths(PathSelectors.any()) // PathSelectors.ant("/foos/*")
				.build().enable(true).apiInfo(apiInfo())
				.securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("apiKey", "Authorization", "header"))));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Todo List App").description("Todo List App public and private API")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("http://swagger.io/terms/").version("1.0.0").build();
	}

}

