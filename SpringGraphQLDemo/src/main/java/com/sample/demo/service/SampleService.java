package com.sample.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.domain.Sample;
import com.sample.demo.repository.SampleRepository;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;


@Service
//추가
@GraphQLApi
public class SampleService {

	@Autowired
	private SampleRepository SampleRepository;
	
	public SampleService(SampleRepository SampleRepository) {
		this.SampleRepository = SampleRepository;
	}
	
	//{
	//	Samples{
	//		id
	//  	title
	//	}
	//}
	
	@GraphQLQuery(name = "Samples")
	public List<Sample> getSamples(){
		return SampleRepository.findAll();
	}
	
	//{
	//	Sample(id:1){
	//		id
	//		title
	//	}
	//}
	@GraphQLQuery(name = "Sample")
	public Optional<Sample> getSampleById(Long id){
		return SampleRepository.findById(id);
	}
	
	//mutation{
	//	saveSample(Sample:{title:"title"}){
	//		id
	//		title
	//	}
	//}
	
	@GraphQLMutation(name = "saveSample")
	public Sample saveSample(Sample Sample) {
		return SampleRepository.save(Sample);
	}
	
	//mutation{
	//	deleteSample(id:1)
	//}
	@GraphQLMutation(name = "deleteSample")
	public void deleteSample(Long id) {
		SampleRepository.deleteById(id);
	}
	
	//{
	//	Samples{
	//		title
	//		isGood
	//	}
	//}
	@GraphQLQuery(name = "isGood")
	public boolean isGood(@GraphQLContext Sample Sample) {
		return !Sample.getTitle().equals("title1");
	}
}
