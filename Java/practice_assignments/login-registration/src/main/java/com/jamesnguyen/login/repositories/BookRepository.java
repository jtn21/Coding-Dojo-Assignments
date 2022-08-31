package com.jamesnguyen.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesnguyen.login.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

		List<Book> findAll();
}
