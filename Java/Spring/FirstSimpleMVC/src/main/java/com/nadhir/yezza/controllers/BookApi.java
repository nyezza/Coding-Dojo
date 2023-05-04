package com.nadhir.yezza.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadhir.yezza.models.Book;
import com.nadhir.yezza.services.BookService;

@RestController
public class BookApi {

	// Dependency injection
	
	private final BookService BookServ;
	
	public BookApi(BookService BookService) {
		this.BookServ = BookService;
		
	}
	
	
		@RequestMapping("/api/index")
		public String index() {
		List<Book>	listOfBookks =  BookServ.allBooks();
			return "lis of book"+listOfBookks;
		}
		
		@RequestMapping("/api/create")

}
