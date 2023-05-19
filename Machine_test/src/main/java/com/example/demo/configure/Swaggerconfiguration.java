package com.example.demo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class Swaggerconfiguration 
{
	@Bean
	public OpenAPI SwaggerCnfig()
	{
		return  new OpenAPI().info(new Info().title("MachineTest").version("1.0.0").description("Your Search Ends Here"));
	}

}
