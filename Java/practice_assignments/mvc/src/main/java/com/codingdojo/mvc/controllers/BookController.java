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
	
	@Autowired
	private BookService bookService;
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		Book foundBook = bookService.findBook(id);
		System.out.println(foundBook);
		model.addAttribute("book", foundBook);

		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		
		model.addAttribute("bookList", books);
		
		return "index.jsp";
	}
	
	
	

}
