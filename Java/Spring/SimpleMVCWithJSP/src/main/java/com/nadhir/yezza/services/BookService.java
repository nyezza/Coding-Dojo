package com.nadhir.yezza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nadhir.yezza.models.Book;
import com.nadhir.yezza.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}
	
	// find ALL
	
	public List<Book> findAllBook(){
		
		return bookRepo.findAll();
	}
	
	// find By ID
	
	public Book findById(Long ID) {
		Optional<Book> bookFound = bookRepo.findById(ID);
		if (bookFound.isPresent() == true) {
			return bookFound.get();
		}
		else {
			return null;
		}
	}
	
	// Create book
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// update book
	
	public Book updatebook(Book book) {
		return bookRepo.save(book);
	}
	
	// Delete book
	public void deleteBook(Long ID) {
		bookRepo.deleteById(ID);
	}
}
