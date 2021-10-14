package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository repo;
	
	// Method to find all Ninjas
	public List<Ninja> allNinjas() { // returns all the people
		return repo.findAll();
	}
	
	// Method to create a Ninja
	public Ninja create(
			Ninja Ninja) { // creates a Ninja
		return repo.save(Ninja);
	}
	
	// Method to find one Ninja by ID
	public Ninja findById(
			Long id) { // retrieves a Ninja
		Optional<Ninja> optionalNinja = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalNinja.isPresent()) { // checks if our object exists
			return optionalNinja.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
	}
//	 public Ninja update( // updates a Ninja
//	 		Long id, 
//	 		String name, 
//	 		String vendor, 
//	 		Double cost,
//	 		String description) {
//	 	Ninja Ninja = this.findNinja(id);
//		
//	 	Ninja.setName(name);
//	 	Ninja.setVendor(vendor);
//	 	Ninja.setCost(cost);
//	 	Ninja.setDescription(description);
//		
//	 	return repo.save(Ninja);
//	}
	 public Ninja update( // updates a Ninja
		 		Ninja ninja) {
		 	return repo.save(ninja);
	 }
	
	// Method to delete a Ninja
	public void destroy(
			Long id) {// deletes an Ninja
		repo.deleteById(id);
	}
}
