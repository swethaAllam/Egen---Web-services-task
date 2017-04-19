package com.egen.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1799591782757657176L;

	@Id
	@Column(name ="BOOK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bookId;
	
	@Column(name ="NAME")
	private String name;
	
	@Column(name ="")
	private ArrayList<String> authors;
	
	@Column(name ="CHECKED_OUT_BY")
	private UserEntity checkedOutBy;
}
