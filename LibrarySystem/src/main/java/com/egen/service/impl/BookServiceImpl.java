package com.egen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.dao.BookDAO;
import com.egen.entity.BookEntity;
import com.egen.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	public List<BookEntity> getAllBooks() {
		List<BookEntity> books = null;
		books = bookDAO.getAllBooks();
		return books;
	}

	public List<BookEntity> getBookByName(String name) {
		List<BookEntity> books = null;
		books = bookDAO.getBookByName(name);
		return books;
	}

	public void addBook(BookEntity book) {
		bookDAO.addBook(book);
		
	}

}
