package org.example.bookstore.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotNull(message = "First name is required")
        @NotEmpty(message = "First name is required")
        @Size(min = 6, max = 20, message = "First name must be between 6 and 20 characters")
        String firstName,
        @NotNull(message = "Last name is required")
        @NotEmpty(message = "Last name is required")
        @Size(min = 6, max = 20, message = "Last name must be between 6 and 20 characters")
        String lastName,
        @NotNull(message = "Username is required")
        @NotEmpty(message = "Username is required")
        @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
        String username,
        @NotNull(message = "Email is required")
        @NotEmpty(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,
        @NotNull(message = "address is required")
        @NotEmpty(message = "address is required")
        String address,
        @NotNull(message = "Password is required")
        @NotEmpty(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        String password
) {
}
