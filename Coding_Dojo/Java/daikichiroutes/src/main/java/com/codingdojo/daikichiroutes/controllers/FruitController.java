package com.codingdojo.daikichiroutes.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) { // Creation of Model
		String fruit = "banana";
		
		model.addAttribute("fruit", fruit);  // Dependency injection
	    	
	    return "index.jsp"; // Sends Model attribute information to index.jsp (located in WEB-INF folder) for rendering
	}
}
