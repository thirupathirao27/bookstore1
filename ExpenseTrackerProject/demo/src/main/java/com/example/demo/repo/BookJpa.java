package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookJpa extends JpaRepository<Book, Integer>{

}
