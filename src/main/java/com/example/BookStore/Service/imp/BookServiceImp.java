package com.example.BookStore.Service.imp;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Enums.SessionStatus;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Repository.CartRepository;
import com.example.BookStore.Repository.SessionRepository;
import com.example.BookStore.Service.BookService;
import com.example.BookStore.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp  implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CartRepository  cartRepository;
    @Autowired
    SessionService sessionService;


    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
       return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void delete(String isbn) {
        Book book = findByIsbn(isbn);
        bookRepository.delete(book);

    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addToCart(String isbn) {
        Session session=sessionService.findActivateSession();
        System.out.println(session);
        if(session==null) return;

        User user = session.getUser();
        Cart cart= cartRepository.findByUser(user);
        System.out.println(cart);
        if(cart==null)
        {
            cart=new Cart();
            cart.setUser(user);
        }

        Book book = findByIsbn(isbn);
        List<Book> booksInCart = cart.getBooks();
        booksInCart.add(book);
        cartRepository.save(cart);
    }



}
