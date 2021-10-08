package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.counter.models.Counter;

@Controller
public class CounterController {
 
	
 @RequestMapping("/")
 public String index(HttpSession session) { // Setting session attributes
	 Integer currentCount = (Integer) session.getAttribute("count");
	 
	 if (currentCount == null) {
		currentCount = 0;
	}
	 
	 session.setAttribute("count", currentCount + 1);
	 
	 System.out.printf("index method - session.getAttribute(\"count\"): %d%n", session.getAttribute("count"));
	 
	 
//	 Counter count = new Counter(currentCount);
	 
//	 System.out.println(session);
//	 System.out.printf("index method - count.getCount(): %d%n", count.getCount());
     
     return "index.jsp";
 }
 
 @RequestMapping("/counter")
// public String count(Model model) {
public String count(HttpSession session, Model model) { // Getting session attributes
	 Integer currentCount = (Integer) session.getAttribute("count");
	 
	 if (currentCount == null) {
		currentCount = 0;
	}
	 
	 model.addAttribute("countToShow", currentCount);
	 
//	 Counter count = new Counter(currentCount);
//	 
//	 count.getCount();
          
//	 System.out.printf("count method - session.getAttribute(\"count\"): %d%n",session.getAttribute("count"));
//	 System.out.printf("count method - count.getCount(): %d%n", count.getCount());
	 
     return "showCount.jsp";
 }
}
