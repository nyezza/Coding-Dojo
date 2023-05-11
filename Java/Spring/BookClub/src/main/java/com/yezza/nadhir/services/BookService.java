package com.yezza.nadhir.services;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yezza.nadhir.repositories.BookRepository;

public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findAllBook(){
		return 
	}
	
	

}
