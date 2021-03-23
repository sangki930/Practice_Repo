package com.sample.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Batchdemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Batchdemo3Application.class, args);
	}

}
