package com.example.Portfolio.controller;
import com.example.Portfolio.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Map<Long, Book> bookStore = new HashMap<>();
    private Long idCounter = 1L;

    // @GetMapping
    // public List<Book> getAllBooks() {
    // return new ArrayList<>(bookStore.values());
    // }

    @GetMapping
    public String testEndpoint() {
        return "bish endpoint is working!";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookStore.get(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId(idCounter++);
        bookStore.put(book.getId(), book);
        return book;
    }
}
