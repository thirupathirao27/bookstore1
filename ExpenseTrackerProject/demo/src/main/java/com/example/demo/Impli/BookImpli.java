package com.example.demo.Impli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookJpa;
@Component
public class BookImpli implements BookDao{

	@Autowired
	private BookJpa repo;
	
	@Override
	public void addBook(Book book) {
		
		repo.save(book);
		
	}
	
	@Override
	public List<Book> displayBooks() {

       List<Book> book=repo.findAll();
       return book;
	}
}
