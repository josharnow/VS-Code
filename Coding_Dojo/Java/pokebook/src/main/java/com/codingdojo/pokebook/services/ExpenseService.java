package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.repositories.ExpenseRepository;

@Service // This annotation will allows Spring to inject this class as a dependency in any controller.
public class ExpenseService {
//	private final ExpenseRepository repo; // adding the expense repository as a dependency
//	public ExpenseService(ExpenseRepository repo) {
//		this.repo = repo;
//	}
	
	@Autowired
	ExpenseRepository repo;
	
	public List<Expense> allExpenses() { // returns all the expenses
		return repo.findAll();
	}
	public Expense createExpense(
			Expense expense) { // creates an expense
		return repo.save(expense);
	}
	public Expense findExpense(
			Long id) { // retrieves an expense
		Optional<Expense> optionalExpense = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalExpense.isPresent()) { // checks if our object exists
			return optionalExpense.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
	}
	public Expense updateExpense( // updates an expense
			Long id, 
			String expenseName, 
			String vendor, 
			Double cost,
			String description) {
		Expense expense = this.findExpense(id);
		
		expense.setExpenseName(expenseName);
		expense.setVendor(vendor);
		expense.setCost(cost);
		expense.setDescription(description);
		
		return repo.save(expense);
	}
//	public Expense updateExpense( // updates an expense
//			Expense expense) {
//		String expenseName = expense.getExpenseName();
//		String vendor = expense.getVendor();
//		Double cost = expense.getCost();
//		String description = expense.getDescription();
//		
//		expense.setExpenseName(expenseName);
//		expense.setVendor(vendor);
//		expense.setCost(cost);
//		expense.setDescription(description);
//		
//		return repo.save(expense);
//	}
	public void deleteExpense(
			Long id) {// deletes an expense
		repo.deleteById(id);
	}
}
