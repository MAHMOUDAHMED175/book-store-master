package org.example.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entities.Cart;
import org.example.bookstore.entities.CartItem;
import org.example.bookstore.repositories.CartItemRepository;
import org.example.bookstore.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart findCartByUserId(Long id) {
        return cartRepository.findByUserId(id);
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
