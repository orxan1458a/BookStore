package com.example.BookStore.Service;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.User;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    void create(Book book);
    List<Book> findAll();
    Book findByIsbn(String isbn);
    void delete(String isbn);
    void save(Book book);
    void addToCart(String isbn);

}
