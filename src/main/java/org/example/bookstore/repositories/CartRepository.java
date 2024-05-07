package org.example.bookstore.repositories;

import org.example.bookstore.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c JOIN c.user u WHERE u.id = :id")
    Cart findByUserId(Long id);
}
