package com.sample.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Sample {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GraphQLQuery(name="id")
	private Long id;
	
	@GraphQLQuery(name="title")
	private String title;

}
