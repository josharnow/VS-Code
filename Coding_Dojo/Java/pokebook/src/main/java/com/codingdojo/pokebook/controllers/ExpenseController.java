package com.codingdojo.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.ExpenseService;

@Controller
public class ExpenseController {
//	private Validator validator;
	
	@Autowired
	ExpenseService service;
	
	@GetMapping("/expenses")
	public String index(
			Model model,
			@ModelAttribute("expense") Expense expense) {
		List<Expense> allExpenses = service.allExpenses();
		model.addAttribute("expenses", allExpenses); // What items="${expenses}" refers to from index.jsp
		
    	//COMMENT OUT?
		// model.addAttribute("expense", new Expense()); // Required to address this error: "Neither BindingResult nor plain target object for bean name 'expense' available as request attribute:
		return "/expenses/index.jsp";
	}
	@GetMapping("/expenses/{id}") // URL contains path variable
	public String show(
			Model model, 
			@PathVariable("id") Long id) { // @PathVariable() argument must match path variable supplied in URL above
		
		System.out.println(id);
		Expense expense = service.findExpense(id);
		System.out.println(expense);
		
		model.addAttribute("expense", expense);
		
		return "/expenses/show.jsp";
	}
	
//	@GetMapping("/expenses/submitForm")
//    public String create(
//    		Model model) {
//        model.addAttribute("expense", new Expense());
//        return "formButton";
//    }
	
//	@PostMapping("/expenses/submitForm")
	@PostMapping("/expenses")
	public String processCreate(
			@Valid @ModelAttribute("expense") Expense expense, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
			BindingResult result,
			Model model) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.

//	    redirectAttributes.addFlashAttribute("error", result);
	    System.out.println(result.getAllErrors());
	    
	    if (result.hasErrors()) {
//	    	return "redirect:/expenses/createError";
//	    	return "redirect:/expenses";
			List<Expense> allExpenses = service.allExpenses();
			model.addAttribute("expenses", allExpenses);
	    	
	    	return "/expenses/index.jsp";
		}
	    
	    service.createExpense(expense);
	    return "redirect:/expenses";
	}
	@GetMapping("/expenses/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model) {

		Expense expense = service.findExpense(id);
		model.addAttribute("expense", expense);
	
		return "/expenses/edit.jsp";
	}
	
//	@GetMapping("/expenses/submitForm")
//    public String create(
//    		Model model) {
//        model.addAttribute("expense", new Expense());
//        return "formButton";
//    }
	@PutMapping("/expenses/{id}/update")
	public String update(
			@Valid @ModelAttribute("expense") Expense expense, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
			BindingResult result) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.

	    if (result.hasErrors()) {
	    	return "/expenses/edit.jsp";
		} else {
			Long id = expense.getId();
			String expenseName = expense.getExpenseName();
			String vendor = expense.getVendor();
			Double cost = expense.getCost();
			String description = expense.getDescription();
			//	service.updateExpense(expense);
			service.updateExpense(id, expenseName, vendor, cost, description);
			return "redirect:/expenses";
		}
	    
	}
	@DeleteMapping("/expenses/{id}/destroy")
    public String destroy(
    		@PathVariable("id") Long id) {
        service.deleteExpense(id);
        return "redirect:/expenses";
    }
	
//	@GetMapping("/expenses/new")
//	public String newExpense(
//			@ModelAttribute("expense") Expense expense) {
//		return "/expenses/new.jsp";
//	}
//	@GetMapping("/expenses/createError")
//	public String flashMessages(
//			RedirectAttributes redirectAttributes) {
////		redirectAttributes.
////		System.out.println(result.getAllErrors());
//		
////			redirectAttributes.addFlashAttribute("error", result);
////
////		for (String[] error : errors) {
////			System.out.println(error);
////		}
//		return "/expenses/index.jsp";
//	}
}