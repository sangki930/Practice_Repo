package com.psk.hr.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psk.hr.demo.domain.account.UserItem;
import com.psk.hr.demo.repo.UserItemRepository;
import com.psk.hr.demo.repo.UserSpecs;
import com.psk.hr.demo.repo.UserSpecs.SearchKey;

@Controller
public class TestController {
	
	@Autowired
	private UserItemRepository userRepo;

	@RequestMapping("/ns")
	public String ns() {
	
		return "newFile";
	}
	
	@RequestMapping("/n")
	public String n() {
	
		return "thymeleaf/test";
	}
	
	@RequestMapping("/nn")
	public String nn() {
		return "thymeleaf/Newfile";
	}
	
	
	//테스트 메소드
	@GetMapping("/post/list")
//	public List<UserItem> getPostList(@RequestParam(required = false) Map<String, Object> searchRequest) {
		public List<UserItem> getPostList(Map<String, Object> searchRequest) {
	    Map<String, Object> searchKeys = new HashMap<>();
	    for (String key : searchRequest.keySet()) {
	        searchKeys.put(key.toUpperCase(), searchRequest.get(key));
	    }
	    return searchKeys.isEmpty()
	            ? userRepo.findAll()
	            : userRepo.findAll(UserSpecs.search(searchKeys));
	}
	
	
	
	
}
