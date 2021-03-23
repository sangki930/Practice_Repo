package com.sample.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.demo.domain.Sample;
import com.sample.demo.service.SampleService;

@SpringBootApplication
public class SpringGraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlDemoApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(SampleService sampleService) {
		return args->{
			Stream.of("title1","title2","title3","title4","마지막")
			.forEach(title->{
				Sample sample = new Sample();
				sample.setTitle(title);
				sampleService.saveSample(sample);
			});
			sampleService.getSamples().forEach(System.out::println);
		};
	}

}
