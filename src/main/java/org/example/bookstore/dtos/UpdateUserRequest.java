package org.example.bookstore.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @Size(min = 6, max = 20, message = "First name must be between 6 and 20 characters")
        String firstName,
        @Size(min = 6, max = 20, message = "Last name must be between 6 and 20 characters")
        String lastName,
        @Email(message = "Email should be valid")
        String email,
        @Size(min = 8, message = "Password must be at least 8 characters")
        String password
) {
}
