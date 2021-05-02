package com.example.BookStore.Service;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.User;

public interface CartService {
    Cart findActiveCart();
    void removeBook(String isbn);
}
