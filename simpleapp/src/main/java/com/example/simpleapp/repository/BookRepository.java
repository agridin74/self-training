package com.example.simpleapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.simpleapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByTitle(String title);

}
