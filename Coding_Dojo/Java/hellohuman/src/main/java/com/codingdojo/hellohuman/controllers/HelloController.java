package com.codingdojo.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping("/")
//    public String index(@RequestParam(name = "first_name", required = false) String firstNameQuery,
//    					@RequestParam(name = "last_name", required = false) String lastNameQuery) {
//    	if(firstNameQuery == null && lastNameQuery == null) {
//    		return "Hello Human";
//    	} else if (lastNameQuery == null) {
//    		return "Hello " + firstNameQuery;
//    	} else if (firstNameQuery == null) {
//    		return "Hello " + lastNameQuery;
//    	} else {
//    		return "Hello " + firstNameQuery + " " + lastNameQuery;
//    	}
//    }
	
    @RequestMapping("/")
    public String index(@RequestParam(name = "first_name", required = false) String firstNameQuery,
    					@RequestParam(name = "last_name", required = false) String lastNameQuery,
    					@RequestParam(name = "times", required = false) int multiplier) {
    	if (firstNameQuery == null && lastNameQuery == null || multiplier <= 0) {
    		return "Hello Human";
    	} else if (multiplier > 0){
    		String[] helloNameArray = new String[multiplier];
    		for (int i = 0; i < multiplier; ++i) {
    			helloNameArray[i] = "Hello " + firstNameQuery + lastNameQuery;
    		}
    		return String.join(" ", helloNameArray);
    	} else {
    		return "Hello " + firstNameQuery + lastNameQuery;
    	}
    	
    		
//    	else {
//    		boolean isMultiplier = false;
//    		if (multiplier >= 0) {
////    			!isMultiplier;
//    			isMultiplier = true;
//    		}
//    		
//    		if (isMultiplier = true) {
//    			String[] helloNameArray = new String[multiplier];
//    			
//    			for (int i = 0; i < multiplier; ++i) {
//    				helloNameArray[i] = "Hello " + firstNameQuery + lastNameQuery;
//    			}
//    			
//    			return String.join(" ", helloNameArray);
//    		} else {
//    			return "Hello " + firstNameQuery + lastNameQuery;
//    		}
    		
    		
//    		
////    		return firstNameQuery + lastNameQuery + multiplier;
    		
//    		int i = 0;
//    		while (i < multiplier) {
////    			return "Hello " + firstNameQuery + lastNameQuery + multiplier;
//			}
    	
    	
    	
    	
    	
//    	else if (lastNameQuery == null) {
//    		return "Hello " + firstNameQuery;
//    	} else if (firstNameQuery == null) {
//    		return "Hello " + lastNameQuery;
//    	} else {
//    		return "Hello " + firstNameQuery + " " + lastNameQuery;
//    	}
//    }
}}