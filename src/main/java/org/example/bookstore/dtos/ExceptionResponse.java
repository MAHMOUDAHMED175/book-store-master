package org.example.bookstore.dtos;

public record ExceptionResponse(
        int statusCode,
        String message,
        String path
) {
}
