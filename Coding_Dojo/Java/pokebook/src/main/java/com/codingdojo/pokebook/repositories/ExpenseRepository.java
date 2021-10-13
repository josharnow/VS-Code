package com.codingdojo.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.pokebook.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> { // Creates a repository that will expose the Spring Data JPA. This will expose a variety of methods, as well as allow us to extend it. <Model, Primary Key (ID) Type>
	List<Expense> findAll(); // this method retrieves all the expenses from the database
	Long countByExpenseNameContaining(String search); // this method counts how many expense names contain a certain string
	Long deleteByExpenseNameStartingWith(String search); // this method deletes an expense that starts with a specific string
	List<Expense> findByExpenseNameIs(String expenseName); // this method retrieves a list of expenses with the given expense name
	
	List<Expense> findByDescriptionContaining(String search); // this method finds expenses with descriptions containing the search string
}



