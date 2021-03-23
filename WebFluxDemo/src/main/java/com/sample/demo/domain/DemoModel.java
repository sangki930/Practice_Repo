package com.sample.demo.domain;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoModel {

	@NotEmpty
	private String id;
	private Map<String,String> data;
	private LocalDateTime createDateTime = LocalDateTime.now();
	private String source;
	private double version = 1.0;
}
