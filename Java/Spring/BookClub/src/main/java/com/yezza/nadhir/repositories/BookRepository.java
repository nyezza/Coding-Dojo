package com.yezza.nadhir.repositories;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

}
