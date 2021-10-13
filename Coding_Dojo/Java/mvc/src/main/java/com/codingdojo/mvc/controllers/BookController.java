package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired // In place of creating bookService variable and putting it into the constructor is @Autowired; this does dependency injection for you. Saves a few lines of code
	BookService service;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = service.allBooks();
		model.addAttribute("books", books); // What items="${books}" refers to from index.jsp
		return "/books/index.jsp";
	}
	@GetMapping("/books/{bookId}") // URL contains path variable
	public String show(
			Model model, 
			@PathVariable("bookId") Long bookId) { // @PathVariable() argument must match path variable supplied in URL above
		
		System.out.println(bookId);
		Book book = service.findBook(bookId);
		System.out.println(book);
		
//		ArrayList<Book> books = bookService.getAllBooks();
		
		model.addAttribute("book", book);
		
		return "/books/show.jsp";
	}
	
    @PostMapping("/books")
    public String create(
    		@Valid @ModelAttribute("book") Book book, // @ModelAttribute is not used here to access data sent with the request, but rather to instantiate a new Book type and bind to our view model. Since no Book is being passed, an empty book will be instantiated and bound to our view model; the binding to our model will allow us to create a form that is also bound to the Book type. allowing us to validate the information against our Book type. @Calid is used to check to see if the submitted object passes validation.
    		BindingResult result) { // BindingResult is also injected to see if the object passes validation; must come immediately after @Valid parameter.
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            service.createBook(book);
            return "redirect:/books";
        }
    }
    @GetMapping("/books/new")
    public String newBook(
    		@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }

}
