package org.example.bookstore.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record  BookRequest (
        @NotNull(message = "Title is required")
        @NotEmpty(message = "Title is required")
        String title,
        @NotNull(message = "Author is required")
        @NotEmpty(message = "Author is required")
        String author,
        @NotNull(message = "Price is required")
        @NotNull(message = "Price is required")
        Double price,
        @NotNull(message = "ISBN is required")
        @NotEmpty(message = "ISBN is required")
        String isbn,
        @NotNull(message = "Description is required")
        @NotEmpty(message = "Description is required")
        String description,
        @NotNull(message = "Publication date is required")
        @NotEmpty(message = "Publication date is required")
        Date publicationDate,
        @NotNull(message = "Stock is required")
        @NotEmpty(message = "Stock is required")
        Integer stock
) {
}
