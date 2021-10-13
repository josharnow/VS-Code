package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service // This annotation will allows Spring to inject this class as a dependency in any controller.
public class BookService {

 private final BookRepository repo; // adding the book repository as a dependency
 
 public BookService(BookRepository repo) {
     this.repo = repo;
 }
 public List<Book> allBooks() { // returns all the books
     return repo.findAll();
 }
 public Book createBook(Book b) { // creates a book
     return repo.save(b);
 }
 public Book findBook(Long id) { // retrieves a book
     Optional<Book> optionalBook = repo.findById(id); // returns an optional object that may or may not contain (hence, Optional) our book object
     if(optionalBook.isPresent()) { // checks if our object exists
         return optionalBook.get(); // if the object exists, we return our book object by calling the get() method
     } else {
         return null; // if the object does not exists, returns null.
     }
 }
public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) { // updates a book
	// TODO Auto-generated method stub
	Book book = this.findBook(id);
		
	book.setTitle(title);
	book.setDescription(desc);
	book.setLanguage(lang);
	book.setNumberOfPages(numOfPages);
		
//	bookRepository.saveAll();
	return repo.save(book);
	}
public void deleteBook(Long id) {// deletes a book
	repo.deleteById(id);
}

 
 
}


