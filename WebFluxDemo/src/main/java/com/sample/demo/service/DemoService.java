package com.sample.demo.service;

import org.springframework.stereotype.Service;

import com.sample.demo.domain.DemoModel;
import com.sample.demo.domain.DemoResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DemoService {

		public Flux<DemoResponse> post(Flux<DemoModel> demoModelFlux){
	
		return demoModelFlux
				.flatMap(demoModel ->{
					log.debug("demoModel : {}",demoModel);
					return Flux.just(new DemoResponse(demoModel,true));
				});
	}

		public Mono<String> getHello() {
			// TODO Auto-generated method stub
			return null;
		}
	
}
