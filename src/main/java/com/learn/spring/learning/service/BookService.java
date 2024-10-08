package com.learn.spring.learning.service;

import com.learn.spring.learning.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    List<Book> listBook();

    Book checkBook(Integer id);

    void updateBook(Book book, Integer id);

    void deleteBook(Integer id);
}
