package com.sample.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@Table(name="sampleone")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SampleOne {

	@Id
	private Long id;
	
	@Column
	private String column1;
	@Column
	private String column2;
	@Column
	private String column3;
}
