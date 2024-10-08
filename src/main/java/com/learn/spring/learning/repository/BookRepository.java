package com.learn.spring.learning.repository;

import com.learn.spring.learning.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
