package com.example.BookStore.Repository;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUser(User user);

}
