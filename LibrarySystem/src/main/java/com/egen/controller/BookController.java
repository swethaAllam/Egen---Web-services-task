package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egen.entity.BookEntity;
import com.egen.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/allBooks", method = RequestMethod.GET)
	public @ResponseBody List<BookEntity> getAllBooks(){
		List<BookEntity> booksList = null;
		booksList = bookService.getAllBooks();
		return booksList;
		
	}

	@RequestMapping(value="/findBook", method = RequestMethod.GET)
	public @ResponseBody List<BookEntity> findBookByName(@RequestParam(value="name", required=true) String name){
		List<BookEntity> booksList = null;
		booksList = bookService.getBookByName(name);
		return booksList;
		
	}

	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public void addBook(@RequestBody BookEntity book){
		bookService.addBook(book);
	}

	
	@RequestMapping(value="/checkOutBook{id}", method = RequestMethod.POST)
	public void checkOutBook(@PathVariable("bookId") long bookId, @PathVariable("id") long userId){
		
	}

	 

}
