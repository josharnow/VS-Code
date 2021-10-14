package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import com.codingdojo.dojosandninjas.models.Dojo;

@Service
public class DojoService {
	@Autowired
	DojoRepository repo;
	
	// Method to find all Dojos
	public List<Dojo> allDojos() { // returns all the dojos
		return repo.findAll();
	}
	// Method to create a Dojo
	public Dojo create(
			Dojo dojo) { // creates a Dojo
		return repo.save(dojo);
	}
	
	// Method to find one Dojo by ID
	public Dojo findById(
			Long id) { // retrieves a Dojo
		Optional<Dojo> optionalDojo = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalDojo.isPresent()) { // checks if our object exists
			return optionalDojo.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
	}
//	 public Dojo updateDojo( // updates a Dojo
//	 		Long id, 
//	 		String name, 
//	 		String vendor, 
//	 		Double cost,
//	 		String description) {
//	 	Dojo dojo = this.findDojo(id);
//		
//	// 	dojo.setName(name);
//	// 	dojo.setVendor(vendor);
//	// 	dojo.setCost(cost);
//	// 	dojo.setDescription(description);
//		
//	// 	return repo.save(dojo);
//	}
	// Method to update a Dojo
	 public Dojo update( // updates a Dojo
		 		Dojo dojo) {
		 return repo.save(dojo);
		}
	
	// Method to delete a Dojo
	public void destroyDojo(
			Long id) {// deletes an Dojo
		repo.deleteById(id);
	}
}
