package com.codingdojo.pokebook.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.ExpenseService;

@Controller
public class ExpenseController {
//	private Validator validator;
	
	@Autowired
	ExpenseService service;
	
	@GetMapping("/expenses")
	public String index(
			Model model) {
		List<Expense> allExpenses = service.allExpenses();
		model.addAttribute("expenses", allExpenses); // What items="${expenses}" refers to from index.jsp
		model.addAttribute("expense", new Expense()); // Required to address this error: "Neither BindingResult nor plain target object for bean name 'expense' available as request attribute:
		return "/expenses/index.jsp";
	}
//	@GetMapping("/expenses/{id}") // URL contains path variable
//	public String show(
//			Model model, 
//			@PathVariable("id") Long id) { // @PathVariable() argument must match path variable supplied in URL above
//		
//		System.out.println(id);
//		Expense expense = service.findExpense(id);
//		System.out.println(expense);
//		
//		model.addAttribute("expense", expense);
//		
//		return "/expenses/show.jsp";
//	}
	
	@GetMapping("/expenses/submitForm")
    public String create(
    		Model model) {
        model.addAttribute("expense", new Expense());
        return "formButton";
    }
	
	@PostMapping("/expenses/submitForm")
	public String processCreate(
			@Valid @ModelAttribute("expense") Expense expense, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
			BindingResult result, 
			Model model) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		
//		Set<ConstraintViolation<Expense>> violations = validator.validate(expense);
//		
//	    for (ConstraintViolation<Expense> violation : violations) 
//	    {
//	        String propertyPath = violation.getPropertyPath().toString();
//	        String message = violation.getMessage();
//	        // Add JSR-303 errors to BindingResult
//	        // This allows Spring to display them in view via a FieldError
//	        result.addError(new FieldError("expense", propertyPath, 
//	                "Invalid "+ propertyPath + " (" + message + ")"));
//	    }
		
//	    redirectAttributes.addFlashAttribute("error", result);
	    System.out.println(result.getAllErrors());
	    
	    if (result.hasErrors()) {
//	    	redirectAttributes.addFlashAttribute("errorCount", result.getErrorCount());
//
//	    	redirectAttributes.addFlashAttribute("expenseNameError", result.getFieldErrors());
//	    	redirectAttributes.addFlashAttribute("vendorError", result.getFieldError("vendor"));
//	    	redirectAttributes.addFlashAttribute("costError", result.getAllErrors());
//	    	redirectAttributes.addFlashAttribute("descriptionError", result);
//	    	redirectAttributes.
	    	
	    	
	    	
//	    	for (ConstraintViolation<Expense> violation : violations) 
//	    	{
//	    		String propertyPath = violation.getPropertyPath().toString();
//	    		String message = violation.getMessage();
//	    		// Add JSR-303 errors to BindingResult
//	    		// This allows Spring to display them in view via a FieldError
//	    		result.addError(new FieldError("expense", propertyPath, 
//	    				"Invalid "+ propertyPath + " (" + message + ")"));
////		        if (propertyPath == "expenseName") {
////		        	redirectAttributes.addFlashAttribute("expenseNameError", message);
////				}
////		        if (propertyPath == "vendor") {
////		        	redirectAttributes.addFlashAttribute("vendorError", message);
////				}
////		        if (propertyPath == "cost") {
////		        	redirectAttributes.addFlashAttribute("costError", message);
////				}
////		        if (propertyPath == "cost") {
////		        	redirectAttributes.addFlashAttribute("costError", message);
////				}
//	    	}
	    	model.addAttribute("expense", new Expense());
	    	
	    	return "redirect:/expenses/createError";
		}
	    
	    service.createExpense(expense);
	    return "redirect:/expenses";
	    
//		if (result.hasErrors()) {
////			return "/expenses/new.jsp";
//			return "redirect:/createError";
//		} else {
//			service.createExpense(expense);
//			return "redirect:/expenses";
//		}
		// Store the expense information in database
	 
	    // Mark Session Complete
//	    status.setComplete();
	}
//	@GetMapping("/expenses/new")
//	public String newExpense(
//			@ModelAttribute("expense") Expense expense) {
//		return "/expenses/new.jsp";
//	}
	@GetMapping("/expenses/createError")
	public String flashMessages(
			RedirectAttributes redirectAttributes) {
//		redirectAttributes.
//		System.out.println(result.getAllErrors());
		
//			redirectAttributes.addFlashAttribute("error", result);
//
//		for (String[] error : errors) {
//			System.out.println(error);
//		}
		return "/expenses/index.jsp";
	}
}