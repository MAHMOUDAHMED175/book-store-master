package org.example.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entities.CartItem;
import org.example.bookstore.repositories.CartItemRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem findCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
