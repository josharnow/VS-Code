package com.codingdojo.formsubmission.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
//	@RequestMapping("/")
	@GetMapping("/") // May also use the syntax @GetMapping instead of @RequestMapping for your GET routes. There is no difference.
	public String index() {
		return "index.jsp";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping("/login") // Alternatively, you can use a shorthand version of the @RequestMapping for POST requests, and it functions the exact same way:
	public String login(
		@RequestParam(value="email") String email, // Note: the value argument must match the name attribute in the HTML form fields.
	    	@RequestParam(value="password") String password) {
	    
	    	// CODE TO PROCESS FORM i.e. check email and password
	    	
//	    	return "results.jsp"; // <-- we'll change this when we learn redirecting
		return "redirect:/dashboard"; // Instead of passing the view engine a path to a file to render, we are sending it an instruction to redirect: "redirect:/dashboard"
	}
	
	// ...
	@RequestMapping(value="/processPayment", method=RequestMethod.POST)
	public String processPayment(
	    @RequestParam(value="creditCardNumber") Integer creditCardNumber,
	    @RequestParam(value="expDate") Date expDate, 
	    @RequestParam(value="amount") Double amount) {
	    
	    // Code here to complete the transaction and charge CC
	    // ** Put any necessary information in session for later **
	        
	    return "redirect:/confirm"; // <-- redirects to a /confirm render route.
	}
	
	 // ...
	    @RequestMapping("/confirm")
	    public String confirmationPage(Model model){
	        
	        // get any info needed out of session and add to the
	        // view model to render on the page.
	            
	        return "confirmation.jsp";
	    }
	    // ...
}

