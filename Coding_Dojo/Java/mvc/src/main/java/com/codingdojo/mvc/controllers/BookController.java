package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired // In place of creating bookService variable and putting it into the constructor is @Autowired; this does dependency injection for you. Saves a few lines of code
	BookService bookService;
	
	@GetMapping("/books/{bookId}") // URL contains path variable
	public String index(
			Model model, 
			@PathVariable("bookId") Long bookId) { // @PathVariable() argument must match path variable supplied in URL above
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
//		ArrayList<Book> books = bookService.getAllBooks();
		
		model.addAttribute("book", book);
		
		return "index.jsp";
	}
}
