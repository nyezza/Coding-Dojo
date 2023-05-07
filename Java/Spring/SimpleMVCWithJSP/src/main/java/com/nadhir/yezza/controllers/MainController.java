package com.nadhir.yezza.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nadhir.yezza.models.Book;
import com.nadhir.yezza.services.BookService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class MainController {
	@Autowired
	private BookService bookServ;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Book> allBook = bookServ.findAllBook();
		model.addAttribute("books",allBook);
		return "allbooks.jsp";
	}
	
	@RequestMapping("/newBook")
	public String newBook(@ModelAttribute("book")Book book) {
		return"createBook.jsp";
	}
	
	@RequestMapping("/processForm")
	public String createBook(@ModelAttribute ("book")Book book) {
		bookServ.createBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showOne(@PathVariable("id") Long id,Model model) {
		//bookServ.findById(id);
		//Book oneBook= bookServ.findById((id)
		model.addAttribute("oneBook",bookServ.findById(id));
		return "showOne.jsp";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editOne(@PathVariable("id")Long id, Model model) {
		Book oneBook=bookServ.findById(id);
		model.addAttribute("oneBook", oneBook);
		return "editBook.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			bookServ.updatebook(book);
			return "redirect:/";
			
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		bookServ.deleteBook(id);
		return "redirect:/";
	}
}
