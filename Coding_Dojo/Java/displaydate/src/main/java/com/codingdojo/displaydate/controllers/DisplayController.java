package com.codingdojo.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class DisplayController {
    @RequestMapping("/")
    public String index(Model model) {
        
//        String name = "Grace Hopper";
//        String itemName = "Copper wire";
//        double price = 5.25;
//        String description = "Metal strips, also an illustration of nanoseconds.";
//        String vendor = "Little Things Corner Store";
//    
//    	// Values to the view model to be rendered
//        model.addAttribute("name", name);
//        model.addAttribute("itemName", itemName);
//        model.addAttribute("price", price);
//        model.addAttribute("description", description);
//        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
        
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	Date date = new Date();
    	
    	String strDate = String.format("%tA, the %te of %tB, %tY", date, date, date, date);
    	
    	model.addAttribute("date", strDate);
    	
    	return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	Date time = new Date();
    	
    	String strTime = String.format("%tl:%tM %Tp", time, time, time);
    	
    	model.addAttribute("time", strTime);
    	
    	return "time.jsp";
    }
       
}