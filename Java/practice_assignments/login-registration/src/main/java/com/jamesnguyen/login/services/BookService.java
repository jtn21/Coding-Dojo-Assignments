package com.jamesnguyen.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesnguyen.login.models.Book;
import com.jamesnguyen.login.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;


	//find all
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	
	
	//find one
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()){
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	
	
	//create
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	 
	
	// update
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	
	// delete
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
}
