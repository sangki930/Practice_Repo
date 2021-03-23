package com.sample.demo.config;

import org.apache.http.entity.ContentType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class DemoRouter {

	//APPLICATION_JSON
	@Bean
	public RouterFunction<ServerResponse> routes(DemoHandler demoHandler){
		

		return RouterFunctions.route(RequestPredicates.POST("/demo").and(contentType(APPLICATION_JSON)), demoHandler::post);
	}
	
}
