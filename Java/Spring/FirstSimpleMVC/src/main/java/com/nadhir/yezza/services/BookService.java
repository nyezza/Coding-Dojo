package com.nadhir.yezza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nadhir.yezza.models.Book;
import com.nadhir.yezza.repositories.BookRepository;

@Service
public class BookService {

// Crud
	

	
	// ...
	    // adding the book repository as a dependency
	
		//Dependency Injection
	    private final BookRepository bookRepo;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepo = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepo.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepo.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepo.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	}

