package com.codingdojo.dojosandninjas.controllers;

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

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	NinjaService ninjaServ;
	DojoService dojoServ;


	 public HomeController(DojoService dojoServ) { 
		 this.dojoServ = dojoServ; 
	 }
	 

	// Shows all the Ninjas
//	@GetMapping("/")
//	public String index(Model model) {
//
//		List<Ninja> allNinjas = ninjaServ.allNinjas();
//		List<Dojo> allDojos = dojoServ.allDojos();
//
//		model.addAttribute("ninjas", allNinjas);
//		model.addAttribute("dojos", allDojos);
//
//		return "index.jsp";
//	}

	// Renders the Form for creating a Ninja
	@GetMapping("/ninjas/new")
	public String newNinja(
			@ModelAttribute("ninja") Ninja ninja,
			Model model) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("dojos", allDojos);
		
		return "/ninjas/new.jsp";
	}

	// Renders the Form for creating a Dojo
	@GetMapping("/dojos/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}

	// This is the action from the form to actually make the ninja
	@PostMapping(value = "/ninjas/new/create")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if (result.hasErrors()) {
				System.out.println("ERROR");
				System.out.printf("ninja - ID: %s%n", ninja.getId());
				System.out.printf("ninja - Dojo: %s%n", ninja.getDojo());
				System.out.printf("ninja - First Name: %s%n", ninja.getFirstName());
				System.out.printf("ninja - Last Name: %s%n", ninja.getLastName());
				System.out.printf("ninja - Age: %d%n", ninja.getAge());
			return "/ninjas/new.jsp";
		}
		ninjaServ.create(ninja);
			System.out.println("Succesfully created ninja? Check mySQL DB...");
			System.out.printf("ninja - ID: %s%n", ninja.getId());
			System.out.printf("ninja - Dojo: %s%n", ninja.getDojo());
			System.out.printf("ninja - First Name: %s%n", ninja.getFirstName());
			System.out.printf("ninja - Last Name: %s%n", ninja.getLastName());
			System.out.printf("ninja - Age: %d%n", ninja.getAge());
		return "redirect:/ninjas/new";
	}

	// This is for the action from the form to actually make the dojo
	@PostMapping(value = "/dojos/new/create")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		}
		dojoServ.create(dojo);
		return "redirect:/dojos/new";
	}

	// Render the jsp for the form to edit a Ninja
	@GetMapping("/ninja/{id}/edit")
	public String editNinja(
			@PathVariable("id") Long id,
			Model model) {
		Ninja ninja = ninjaServ.findById(id);
		model.addAttribute("ninja", ninja);
		return "editNinja.jsp";
	}

	// This is the action from the form to actually EDIT the ninja
	@PutMapping(value = "/ninja/{id}/update")
	public String editingNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "editNinja.jsp";
		} else {
			ninjaServ.update(ninja);
			return "redirect:/";
		}
	}

//	// Show one Ninja
//	@GetMapping("/ninjas/{id}")
//	public String showNinja(
//	@PathVariable("id") Long id, 
//	Model model) {
//		model.addAttribute("ninja", ninjaServ.findById(id));
//		return "/ninjas/show.jsp";
//	}
//	
	// Show one Dojo
	@GetMapping("/dojos/{id}")
	public String showDojo(
			@PathVariable("id") Long id, 
			Model model) {
		model.addAttribute("dojo", dojoServ.findById(id));
		return "/dojos/show.jsp";
	}

	// Delete one Ninja
	@DeleteMapping("/ninjas/{id}/destroy")
	public String destroy(@PathVariable("id") Long id) {
		ninjaServ.destroy(id);
		return "redirect:/";
	}
	
	

}

//
//@GetMapping("/dojos/new")
//public String dojoForm(
//		@Valid @ModelAttribute("dojo") Dojo dojo, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
//		BindingResult result) {
//	return "/dojos/new.jsp";
//}
//
//
//
////@GetMapping("/dojos")
////public String index(
////		Model model,
////		@ModelAttribute("dojo") Dojo dojo) {
////	List<Dojo> allDojos = service.allDojos();
////	model.addAttribute("dojos", allDojos); // What items="${dojos}" refers to from index.jsp
////	
////	//COMMENT OUT?
////	// model.addAttribute("dojo", new Dojo()); // Required to address this error: "Neither BindingResult nor plain target object for bean name 'dojo' available as request attribute:
////	return "/dojos/index.jsp";
////}
////@GetMapping("/dojos/{id}") // URL contains path variable
////public String show(
////		Model model, 
////		@PathVariable("id") Long id) { // @PathVariable() argument must match path variable supplied in URL above
////	
////	Dojo dojo = service.findById(id);
////	
////	model.addAttribute("dojo", dojo);
////	
////	return "/dojos/show.jsp";
////}
//
////@GetMapping("/dojos/submitForm")
////public String create(
////		Model model) {
////    model.addAttribute("dojo", new Dojo());
////    return "formButton";
////}
//
////@PostMapping("/dojos/submitForm")
//
//@PostMapping("/dojos/new/{id}")
//public String processCreate(
//		@PathVariable("id") Long id,
//		@Valid @ModelAttribute("dojo") Dojo dojo, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
//		BindingResult result,
//		Model model) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
//
////    redirectAttributes.addFlashAttribute("error", result);
//    System.out.println(result.getAllErrors());
//    
//    if (result.hasErrors()) {
////    	return "redirect:/dojos/createError";
////    	return "redirect:/dojos";
//		List<Dojo> allDojos = service.allDojos();
//		model.addAttribute("dojos", allDojos);
//    	
//    	return "/dojos/new.jsp";
//	}
//    
//    service.create(dojo);
////    return "redirect:/dojos";
//    return "redirect:/dojos/new";
//}
////@GetMapping("/dojos/edit/{dojo_id}")
////public String edit(
////		@PathVariable("dojo_id") Long id,
////		Model model) {
////
////	Dojo dojo = service.findById(id);
////	model.addAttribute("dojo", dojo);
////
////	return "/dojos/edit.jsp";
////}
//
////@GetMapping("/dojos/submitForm")
////public String create(
////		Model model) {
////    model.addAttribute("dojo", new Dojo());
////    return "formButton";
////}
////@PutMapping("/dojos/{id}/update")
////public String update(
////		@Valid @ModelAttribute("dojo") Dojo dojo, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Valid is used to check to see if the submitted object passes validation.
////		BindingResult result) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
////
////    if (result.hasErrors()) {
////    	return "/dojos/edit.jsp";
////	} else {
////		Long id = dojo.getId();
////		String name = dojo.getName();
////		String vendor = dojo.getVendor();
////		Double cost = dojo.getCost();
////		String description = dojo.getDescription();
////		//	service.updateDojo(dojo);
////		service.updateDojo(id, name, vendor, cost, description);
////		return "redirect:/dojos";
////	}
//    
////}
////@DeleteMapping("/dojos/{id}/destroy")
////public String destroy(
////		@PathVariable("id") Long id) {
////  	service.deleteDojo(id);
////  	return "redirect:/dojos";
////}
//
////@GetMapping("/dojos/new")
////public String newDojo(
////		@ModelAttribute("dojo") Dojo dojo) {
////	return "/dojos/new.jsp";
////}
////@GetMapping("/dojos/createError")
////public String flashMessages(
////		RedirectAttributes redirectAttributes) {
//////	redirectAttributes.
//////	System.out.println(result.getAllErrors());
////	
//////		redirectAttributes.addFlashAttribute("error", result);
//////
//////	for (String[] error : errors) {
//////		System.out.println(error);
//////	}
////	return "/dojos/index.jsp";
////}