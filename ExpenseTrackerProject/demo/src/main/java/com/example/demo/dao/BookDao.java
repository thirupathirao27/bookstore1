package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookDao {

	void addBook(Book book);
	
	List<Book> displayBooks();
}
