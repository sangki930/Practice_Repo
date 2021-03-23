package com.sample.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 출처 : https://jojoldu.tistory.com/330?category=902551
 * */

@Slf4j
@RequiredArgsConstructor
@RestController
public class JobLauncherController {
	
	private final  JobLauncher jobLauncher;
	private final Job job;
	
	@GetMapping("/launchjob")
	public String handle(@RequestParam("fileName") String fileName) throws Exception{
		
		try {
            JobParameters jobParameters = new JobParametersBuilder()
                                    .addString("input.file.name", fileName)
                                    .addLong("time", System.currentTimeMillis())
                                    .toJobParameters();
            //Controller에서 Request Parameter로 받은 값을 Job Parameter로 생성
            
            
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

		return "DONE";
		
	}

}
