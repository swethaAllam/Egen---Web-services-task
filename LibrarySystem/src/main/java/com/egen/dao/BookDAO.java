package com.egen.dao;

import java.util.List;

import com.egen.entity.BookEntity;

public interface BookDAO {

	List<BookEntity> getAllBooks();

	List<BookEntity> getBookByName(String name);

	void addBook(BookEntity book);

}
