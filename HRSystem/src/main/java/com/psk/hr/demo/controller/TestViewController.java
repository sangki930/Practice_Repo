package com.psk.hr.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.psk.hr.demo.domain.HR.HRUseritemEdu;
import com.psk.hr.demo.service.HRService;


@Controller
@RequestMapping("/test")
public class TestViewController {

	
	private static final String folder_name="thymeleaf/test";
	
	@RequestMapping("/testhome")
	public String testhome() {
		
		return folder_name+"/testhome";
		
	}
	
	@RequestMapping("/header")
public String testheader() {
		
		return "thymeleaf/header";
		
	}
	
	@RequestMapping("/aaaa")
	public String testAAAA() {
		
		return folder_name+"/aaaa";
		
	}
	 

	 @RequestMapping(value="/bbbb")
	  public @ResponseBody String updateChkBox (
	      HttpServletRequest request,
	      HttpServletResponse response,
	      @RequestParam(value="name",required=true) List<String> name,
	      @RequestParam(value="age",required=true) List<Integer> age) throws Exception {
	   
	    System.out.println( ">>> param size : " + name.size() );
	     
	    int i = 0;
	    for( String value : name ){
	      System.out.println( ">>> name's value : " + value + "\tage : " + age.get(i) );
	      i++;
	    }
	     
	    return "success";
	  }
	 
	 @RequestMapping(value="/temp")
	 public String template() {
		 
		 return folder_name+"/template";
	 }
	 
	 @RequestMapping(value="/check")
	 public String checktest() {
		 
		 return folder_name+"/checktest";
	 }
	 
	 @RequestMapping(value="/paramtest")
	 public String paramtest() {

		 return folder_name+"/paramtest";
	 }
	 
	 @RequestMapping("/output")
	 public ModelAndView output(Integer[] in) {
		 
		 ModelAndView mv = new ModelAndView();
		 String s = new String();
		 for(Integer i : in) {
			 s+=i;
		 }
		
		 mv.addObject("in", s);
		 mv.setViewName(folder_name+"/output");
		 
		 return mv;
	 }
	 
	 @GetMapping("/edulist")
	 public String edulist1() {
		 return folder_name+"/edulist";
	 }
	 
	 @Autowired
	 private HRService hRService;
	 
	 @RequestMapping("/edulist1")
	 @ResponseBody
	 public List<HRUseritemEdu> edulist2(Model model) throws Exception{
		 
		 List<HRUseritemEdu> edulist = (List<HRUseritemEdu>) hRService.getHR(3L).getEdus();

		 System.out.println(edulist);
		 return edulist;
	 }
	 
}
