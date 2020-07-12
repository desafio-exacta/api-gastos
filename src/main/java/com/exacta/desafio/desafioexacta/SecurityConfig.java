package com.exacta.desafio.desafioexacta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebSecurity
@EnableSwagger2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder
				.builder()
				.deepLinking(true)
		        .displayOperationId(true)
		        .defaultModelsExpandDepth(-1)
		        .defaultModelExpandDepth(0)
		        .defaultModelRendering(ModelRendering.EXAMPLE)
		        .displayRequestDuration(false)
		        .docExpansion(DocExpansion.LIST)
		        .filter(false)
		        .maxDisplayedTags(null)
		        .operationsSorter(OperationsSorter.ALPHA)
		        .showExtensions(false)
		        .showCommonExtensions(false)
		        .tagsSorter(TagsSorter.ALPHA)
		        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
		        .validatorUrl(null)
		        .build();
	}
}