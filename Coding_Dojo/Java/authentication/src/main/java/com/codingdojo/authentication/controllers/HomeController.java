package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(
    		Model model,
    		HttpSession session) {
        if ((boolean) session.getAttribute("logged_in") == true) {
        	Long user_id = (Long) session.getAttribute("user_id");
    		User user = userServ.findById(user_id);
			model.addAttribute("user", user);
			
        	return "home.jsp";
        }
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        
        return "index.jsp";
    }
    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result,
            Model model,
            HttpSession session) {
        if (session.getAttribute("logged_in") == null) {
        	session.setAttribute("logged_in", false);
        }
        boolean logged_in = false;
    	
    	userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            
            return "index.jsp";
        }
        
        logged_in = true;
        session.setAttribute("logged_in", logged_in);
        session.setAttribute("user_id", newUser.getId());
        
        return "redirect:/home";
    } 
    @PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result,
            Model model,
            HttpSession session) {    	
        if (session.getAttribute("logged_in") == null) {
        	session.setAttribute("logged_in", false);
        }
    	boolean logged_in = false;
    	
        User user = userServ.login(newLogin, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            
            return "index.jsp";
        }
        
        logged_in = true;
        session.setAttribute("logged_in", logged_in);
        session.setAttribute("user_id", user.getId());
        
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String home(
    		HttpSession session,
    		Model model) {
        if (session.getAttribute("logged_in") == null || (boolean) session.getAttribute("logged_in") == false) {
        	session.setAttribute("logged_in", false);
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
        	return "index.jsp";
        }
        
    	boolean logged_in = (boolean) session.getAttribute("logged_in");
    	Long user_id = (Long) session.getAttribute("user_id");
//    	model.addAttribute("user", session.getAttribute("user_id");
    	if (logged_in && user_id > 0) {
//			System.out.printf("%s has successfully logged in!%n", session.getAttribute("user_id"));
    		User user = userServ.findById(user_id);
    		System.out.printf("%s has successfully logged in!%n", user.getUsername());
			model.addAttribute("user", user);
//			model.addAttribute("logged_in", logged_in);
			
			return "home.jsp";
		} else {
			return "index.jsp";
		}
    }
    
    @PostMapping("/logout")
    public String logout(
    		HttpSession session,
    		Model model) {   	
    	Long user_id = (Long) session.getAttribute("user_id");
    	User user = userServ.findById(user_id);
    	session.setAttribute("logged_in", false);
    	
    	System.out.printf("Logging %s out...%n", user.getUsername());
    	
    	return "redirect:/";
    }
    
    
}
