package com.learn.spring.learning.controllers;

import com.learn.spring.learning.entity.Book;
import com.learn.spring.learning.service.BookService;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message" , "Successfully Add Book"
        ));
    }

    @GetMapping
    public ResponseEntity<Object> listBook() {
        List<Book> books = bookService.listBook();

        if (books.size() < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "code", "01",
                    "status", "Fail",
                    "message", "Data Not Found!"
            ));
        }

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "data", books,
                "code", "00",
                "status", "Success",
                "message", "Successfully Get Book"
        ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable Integer id) {
        // Check existing data
        Book bookExist = bookService.checkBook(id);

        bookService.updateBook(book, id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message", "Successfully Update Book"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Integer id) {
        // Check existing data
        Book bookExist = bookService.checkBook(id);

        bookService.deleteBook(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "00",
                "status", "Success",
                "message", "Successfully Delete Book"
        ));
    }
}
