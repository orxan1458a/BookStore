package com.example.BookStore.Repository;

import com.example.BookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book,Long> {
    Book findByIsbn(String isbn);
}
