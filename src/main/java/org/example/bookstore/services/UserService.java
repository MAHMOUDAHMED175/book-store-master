package org.example.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dtos.UpdateUserRequest;
import org.example.bookstore.entities.User;
import org.example.bookstore.exception.UserNotFoundException;
import org.example.bookstore.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    public User createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public User updateUser(Long id, UpdateUserRequest user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate == null) {
            throw new UserNotFoundException("User not found");
        }

        userToUpdate.setFirstName(user.firstName());
        userToUpdate.setLastName(user.lastName());
        userToUpdate.setEmail(user.email());
//        userToUpdate.setPassword(passwordEncoder.encode(user.password()));
        return userRepository.save(userToUpdate);
    }


    public void deleteUser(Long id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete == null) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User getUserByUsernameForTest(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }
}
