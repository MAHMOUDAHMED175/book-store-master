package org.example.bookstore.dtos;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String username,
        String email,
        String role
) {
}
