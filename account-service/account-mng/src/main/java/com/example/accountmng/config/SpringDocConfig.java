package com.example.accountmng.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
class SpringDocConfig {

	private final Environment env;

	@Bean
	@Profile( { "local", "dev" } )
	public OpenAPI newOpenAPI() {
		return new OpenAPI().addServersItem(new Server()
				.url("/" + env.getProperty("spring.application.name") + env.getProperty("spring.mvc.servlet.path")));
	}

}
