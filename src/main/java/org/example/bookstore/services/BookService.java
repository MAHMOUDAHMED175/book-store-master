package org.example.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entities.Book;
import org.example.bookstore.exception.BookNotFoundException;
import org.example.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new BookNotFoundException("Book not found");
        }
        return book;
    }

    public Book updateBook(Long id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if (bookToUpdate == null) {
            throw new BookNotFoundException("Book not found");
        }

        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPrice(book.getPrice());
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setDescription(book.getDescription());
        bookToUpdate.setPublicationDate(book.getPublicationDate());
        bookToUpdate.setStock(book.getStock());
        return bookRepository.save(bookToUpdate);
    }

    public void deleteBook(Long id) {
        Book bookToDelete = bookRepository.findById(id).orElse(null);
        if (bookToDelete == null) {
            throw new BookNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}