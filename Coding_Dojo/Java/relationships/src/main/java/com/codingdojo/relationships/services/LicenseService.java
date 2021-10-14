package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

public class LicenseService {
	@Autowired
	LicenseRepository repo;
	
	public List<License> allLicenses() { // returns all the people
		return repo.findAll();
	}
	public License createLicense(
			License License) { // creates a License
		return repo.save(License);
	}
	public License findById(
			Long id) { // retrieves a License
		Optional<License> optionalLicense = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
		if(optionalLicense.isPresent()) { // checks if our object exists
			return optionalLicense.get(); // if the object exists, we return our book object by calling the get() method
		} else {
			return null; // if the object does not exists, returns null.
		}
}
	// public License updateLicense( // updates a License
	// 		Long id, 
	// 		String name, 
	// 		String vendor, 
	// 		Double cost,
	// 		String description) {
	// 	License License = this.findLicense(id);
		
	// 	License.setName(name);
	// 	License.setVendor(vendor);
	// 	License.setCost(cost);
	// 	License.setDescription(description);
		
	// 	return repo.save(License);
//	}
	public void deleteLicense(
			Long id) {// deletes an License
		repo.deleteById(id);
	}
}
