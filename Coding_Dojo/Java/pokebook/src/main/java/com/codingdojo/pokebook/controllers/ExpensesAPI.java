package com.codingdojo.pokebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.ExpenseService;

@RestController
public class ExpensesAPI {
	@Autowired
	ExpenseService service;
	
	@GetMapping("/api/expenses")
	public List<Expense> index() {
		return service.allExpenses();
	}
	@PostMapping("/api/expenses")
	public Expense create(
			@RequestParam(value="expenseName") String expenseName,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="cost") Double cost,
			@RequestParam(value="description") String description) {
		Expense expense = new Expense(expenseName, vendor, cost, description);
		return service.createExpense(expense);
	}
	@GetMapping("/api/expenses/{id}")
	public Expense show(
			@PathVariable("id") Long id) {
			Expense expense = service.findExpense(id);
			return expense;
		}
	@PutMapping("/api/expenses/{id}") // Because this is a put request, it is not expecting to get RequestParams below in the URL itself, but rather sends them through the body of the request
	public Expense update(
			@PathVariable("id") Long id, 
			@RequestParam(value="expenseName") String expenseName,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="cost") Double cost,
			@RequestParam(value="description") String description) {
		Expense expense = service.updateExpense(id, expenseName, vendor, cost, description);
							
					//  Expense expense = new Expense(id, expenseName, vendor, cost, description);
											
						return expense;
				}
	@DeleteMapping("/api/expenses/{id}")
	public void destroy(
			@PathVariable("id") Long id) {
		service.deleteExpense(id);
		}
}
