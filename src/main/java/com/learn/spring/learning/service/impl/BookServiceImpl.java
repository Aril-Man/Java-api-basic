package com.learn.spring.learning.service.impl;

import com.learn.spring.learning.entity.Book;
import com.learn.spring.learning.repository.BookRepository;
import com.learn.spring.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book checkBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Book Id : " + id));

        return book;
    }

    @Override
    public void updateBook(Book book, Integer id) {
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
