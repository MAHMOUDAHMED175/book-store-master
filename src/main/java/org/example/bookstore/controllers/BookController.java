package org.example.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dtos.BookRequest;
import org.example.bookstore.entities.Book;
import org.example.bookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        Book book = new Book(
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.price(),
                bookRequest.isbn(),
                bookRequest.description(),
                bookRequest.publicationDate(),
                bookRequest.stock()
        );
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        Book book = new Book(
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.price(),
                bookRequest.isbn(),
                bookRequest.description(),
                bookRequest.publicationDate(),
                bookRequest.stock()
        );
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("Book deleted successfully");
    }
}