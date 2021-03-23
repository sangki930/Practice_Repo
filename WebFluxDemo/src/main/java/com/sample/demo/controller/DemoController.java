package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sample.demo.config.DemoHandler;
import com.sample.demo.service.DemoService;

import reactor.core.publisher.Mono;

@Controller
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	// 애너테이션 기반 라우팅
	@GetMapping("/hello")
	@ResponseBody
	public Mono<String> getHello() {

	    return demoService.getHello();

	}
	
	// 함수 기반 라우팅
//	@Bean
//	public RouterFunction<ServerResponse> routes(DemoHandler demoHandler) {
//
//	    return RouterFunctions
//	        .route(RequestPredicates.GET("/hello"), demoHandler::getHello);
//
//	}

}
