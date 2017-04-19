package com.egen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.dao.BookDAO;
import com.egen.entity.BookEntity;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<BookEntity> getAllBooks() {
		List<BookEntity> books = new ArrayList<BookEntity>();
		try{
		Session sc = session.openSession();
		Transaction tx = sc.beginTransaction();
		books = sc.createQuery("FROM BOOKENTITY").list();
		tx.commit();
		}
		catch(Exception e){
			System.out.println(e + "exception thrown");
		}
		finally{
			session.close();
		}
		return books;
		
	}

	@SuppressWarnings("unchecked")
	public List<BookEntity> getBookByName(String name) {
		List<BookEntity> books = new ArrayList<BookEntity>();
		try{
		Session sc = session.openSession();
		Transaction tx = sc.beginTransaction();
		books = sc.createQuery("FROM BOOKENTITY where NAME like" + name).list();
		tx.commit();
		}
		catch(Exception e){
			System.out.println(e + "exception thrown");
		}
		finally{
			session.close();
		}
		return books;
	}

	public void addBook(BookEntity book) {
		try{
		Session sc = session.openSession();
		Transaction tx = sc.beginTransaction();
		sc.save(book);
		tx.commit();
		}
		catch(Exception e){
			System.out.println(e + "exception thrown");
		}
		finally{
			session.close();
		}
		
	}

}
