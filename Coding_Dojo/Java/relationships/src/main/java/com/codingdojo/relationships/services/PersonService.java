package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

public class PersonService {
	@Autowired
	PersonRepository repo;
	
	public List<Person> allPersons() { // returns all the people
		return repo.findAll();
	}
	public Person createPerson(
			Person person) { // creates a person
		return repo.save(person);
	}
	public Person findById(
			Long id) { // retrieves a person
		Optional<Person> optionalPerson = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalPerson.isPresent()) { // checks if our object exists
			return optionalPerson.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
}
	// public Person updatePerson( // updates a person
	// 		Long id, 
	// 		String name, 
	// 		String vendor, 
	// 		Double cost,
	// 		String description) {
	// 	Person person = this.findPerson(id);
		
	// 	person.setName(name);
	// 	person.setVendor(vendor);
	// 	person.setCost(cost);
	// 	person.setDescription(description);
		
	// 	return repo.save(person);
	}
	public void deletePerson(
			Long id) {// deletes an person
		repo.deleteById(id);
	}
}
