package com.example.BookStore.Service.imp;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repository.CartRepository;
import com.example.BookStore.Service.CartService;
import com.example.BookStore.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    SessionService sessionService;
    @Override
    public Cart findActiveCart() {
        User user = sessionService.find().getUser();
        return cartRepository.findByUser(user);
    }

    @Override
    public void removeBook(String isbn) {
        Cart cart = findActiveCart();
        List<Book> books = cart.getBooks();
        List<Book> newList = new ArrayList<>();

        for (Book book : books)
            if (!book.getIsbn().equals(isbn))
                newList.add(book);

        cart.setBooks(newList);
        cartRepository.save(cart);
    }
}
