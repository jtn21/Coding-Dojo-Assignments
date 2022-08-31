package com.jamesnguyen.login.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.jamesnguyen.login.models.Book;
import com.jamesnguyen.login.models.LoginUser;
import com.jamesnguyen.login.models.User;
import com.jamesnguyen.login.services.BookService;
import com.jamesnguyen.login.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	
	//------------------------Login & Registration----------------------
	@GetMapping("/")
	public String renderLogReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logregform.jsp";
	}
	
	
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session ) {
		userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logregform.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/books";
	}
	
	

	@PostMapping("/login")
		public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logregform.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/books";
		}
	
	
	@GetMapping("/home")
		public String home(HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
		return "redirect:/home";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findbyId(userId));
		
		return "dashboard.jsp";
	}
	
	
	//-----------------Logout------------------------------------
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session.etAttriute("userId", null)
		session.invalidate();
		return "redirect:/";
	}
	
	// THE ABOVE IS FOR LOGIN AND REGISTRATION-------------------------------------------------------------------------------------------------------------
	
	
	//--------------------Dashboard-------------------------------------------
	@GetMapping("/books")
	public String allBooks(HttpSession session, Model model) {
		//session protection SHOULD BE ADDED TO PREVENT NONLOGGED IN FROM ACCESSING 
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findbyId(userId));
		
		return "dashboard.jsp";
	}

	
	
	//----------------------------------------Create----------------------------
	@GetMapping("/books/add")
	public String renderCreateBook(@ModelAttribute("book")Book book) {
		return "createBook.jsp";
	}
	
	//process form
	@PostMapping("/books/add")
	public String processCreateBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if( result.hasErrors()) {
			return "createBook.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	//-------------------------Edit-------------------------------------

	@GetMapping("/books/edit/{id}")
	public String renderEditDonation(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", bookService.oneBook(id));
		return "editBook.jsp";
	}
	
	
	@PutMapping("/books/edit/{id}")
	public String processEditBook(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else
			bookService.updateBook(book);
			return "redirect:/books";
	}
	
	
	//---------------Find one------------------------------
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", bookService.oneBook(id));
		return "bookDetails.jsp";
	}
	
	
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	
	
	
}
