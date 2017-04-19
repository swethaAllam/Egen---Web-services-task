package com.egen.service;

import java.util.List;

import com.egen.entity.BookEntity;

public interface BookService {
	
	public List<BookEntity> getAllBooks();
	public List<BookEntity> getBookByName(String name);
	public void addBook(BookEntity book);

}
