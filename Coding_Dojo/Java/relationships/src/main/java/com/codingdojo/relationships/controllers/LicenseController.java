package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class LicenseController {
	@Autowired
	LicenseService service;
	
	@GetMapping("/licenses")
	public String index(
			Model model,
			@ModelAttribute("license") License license) {
		List<License> allLicenses = service.allLicenses();
		model.addAttribute("licenses", allLicenses); // What items="${persons}" refers to from index.jsp
		
   	//COMMENT OUT?
		// model.addAttribute("person", new Person()); // Required to address this error: "Neither BindingResult nor plain target object for bean name 'person' available as request attribute:
		return "/licenses/index.jsp";
	}
	@PostMapping("/licenses")
	public String licenses(
			@Valid @ModelAttribute("license") License license) {
	    // error handling with binding result omitted    
	    service.create(license); // Already has the person!
	        
	    return "redirect:/persons";
	}
	@GetMapping("/licenses/{license_id}") // URL contains path variable
	public String show(
			Model model, 
			@PathVariable("license_id") Long id) { // @PathVariable() argument must match path variable supplied in URL above
		
		License license = service.findById(id);
		
		model.addAttribute("license", license);
		
		return "/licenses/show.jsp";
	}
	
//	@GetMapping("/persons/submitForm")
//    public String create(
//    		Model model) {
//        model.addAttribute("person", new Person());
//        return "formButton";
//    }
	
//	@PostMapping("/persons/submitForm")
	
//	@PostMapping("/persons")
//	public String processCreate(
//			@Valid @ModelAttribute("person") Person person, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
//			BindingResult result,
//			Model model) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
//
////	    redirectAttributes.addFlashAttribute("error", result);
//	    System.out.println(result.getAllErrors());
//	    
//	    if (result.hasErrors()) {
////	    	return "redirect:/persons/createError";
////	    	return "redirect:/persons";
//			List<Person> allPersons = service.allPersons();
//			model.addAttribute("persons", allPersons);
//	    	
//	    	return "/persons/index.jsp";
//		}
//	    
//	    service.createPerson(person);
//	    return "redirect:/persons";
//	}
	@GetMapping("/licenses/edit/{license_id}")
	public String edit(
			@PathVariable("license_id") Long id,
			Model model) {

		License license = service.findById(id);
		model.addAttribute("license", license);
	
		return "/licenses/edit.jsp";
	}
	
//	@GetMapping("/persons/submitForm")
//    public String create(
//    		Model model) {
//        model.addAttribute("person", new Person());
//        return "formButton";
//    }
//	@PutMapping("/persons/{id}/update")
//	public String update(
//			@Valid @ModelAttribute("person") Person person, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
//			BindingResult result) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
//
//	    if (result.hasErrors()) {
//	    	return "/persons/edit.jsp";
//		} else {
//			Long id = person.getId();
//			String name = person.getName();
//			String vendor = person.getVendor();
//			Double cost = person.getCost();
//			String description = person.getDescription();
//			//	service.updatePerson(person);
//			service.updatePerson(id, name, vendor, cost, description);
//			return "redirect:/persons";
//		}
	    
	}
	@DeleteMapping("/licenses/{id}/destroy")
   public String destroy(
   		@PathVariable("id") Long id) {
      	service.deleteLicense(id);
      	return "redirect:/licenses";
   }
	
//	@GetMapping("/persons/new")
//	public String newPerson(
//			@ModelAttribute("person") Person person) {
//		return "/persons/new.jsp";
//	}
//	@GetMapping("/persons/createError")
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
//		return "/persons/index.jsp";
//	}
}
