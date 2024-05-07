package org.example.bookstore.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.bookstore.dtos.RegisterRequest;
import org.example.bookstore.dtos.UpdateUserRequest;
import org.example.bookstore.dtos.UserResponse;
import org.example.bookstore.entities.Cart;
import org.example.bookstore.entities.CartItem;
import org.example.bookstore.entities.Order;
import org.example.bookstore.entities.User;
import org.example.bookstore.services.CartService;
import org.example.bookstore.services.OrderService;
import org.example.bookstore.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final CartService cartService;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid RegisterRequest userRequest) {
        User user = new User(
                userRequest.firstName(),
                userRequest.lastName(),
                userRequest.username(),
                userRequest.email(),
                userRequest.password(),
                userRequest.address(),
                "USER");
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getRole());
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest user) {
        User updatedUser = userService.updateUser(id ,user);
        UserResponse userResponse = new UserResponse(
                updatedUser.getId(),
                updatedUser.getFirstName(),
                updatedUser.getLastName(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getRole());
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User deleted successfully");
    }

    @GetMapping("/{id}/cart")
    public ResponseEntity<Cart> getUserCart(@PathVariable Long id) {
        Cart cart = cartService.findCartByUserId(id);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long id) {
        List<Order> orders = orderService.findOrdersByUserId(id);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/{id}/cart/items")
    public ResponseEntity<CartItem> addItemToCart(@PathVariable Long id, @RequestBody CartItem cartItem) {
        cartItem.setCartId(id);
        CartItem createdCartItem = cartService.createCartItem(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/orders")
    public ResponseEntity<Order> createOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setUserId(id);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
}
