package com.sample.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@Configuration
//@RequiredArgsConstructor
public class JobConfiguration {

//	private final JobBuilderFactory jobBuilderFactory;
//	private final StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public Job job() {
//		return jobBuilderFactory.get("job").start(step1()).build();
//	}
//
//	@Bean
//	public Step step1() {
//		return stepBuilderFactory.get("step1").tasklet((contribution, chunkContext) -> {
//			log.info(">>> This is Step1");
//			return RepeatStatus.FINISHED;
//		}).build();
//	}

	

}
