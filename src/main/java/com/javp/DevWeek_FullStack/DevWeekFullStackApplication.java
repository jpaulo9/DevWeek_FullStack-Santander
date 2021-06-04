package com.javp.DevWeek_FullStack;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevWeekFullStackApplication {

	public static void main(String[] args) {

		SpringApplication.run(DevWeekFullStackApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application.description}") String description,@Value("${application.version}") String versao){
		return new OpenAPI().info(
				new Info().title(description)
				.version(versao)
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}


}
