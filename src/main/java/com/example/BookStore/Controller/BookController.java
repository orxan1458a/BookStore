package com.example.BookStore.Controller;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Service.BookService;
import com.example.BookStore.Service.CartService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/book")
@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CartService cartService;
    @PostMapping("/create")
    public String create(@ModelAttribute Book book)
    {
        System.out.println(book);
        bookService.create(book);
        return "books";
    }
    @GetMapping("/list")
    public List<Book> findAll()
    {
       return bookService.findAll();

    }
    @GetMapping("/findDelete")
    public String findDelete(Model model ,@RequestParam String isbn)
    {
        Book book=bookService.findByIsbn(isbn);
        model.addAttribute("book",book);
        return "bookDelete";

    }
    @GetMapping("/find")
    public String find(Model model,String isbn)
    {
        Book book =bookService.findByIsbn(isbn);
        model.addAttribute(book);
        return "bookUpdate";
    }
    @PostMapping(value = "/update",params = "action=Update")
    public String update(@ModelAttribute Book book)
    {
        book.setId(bookService.findByIsbn(book.getIsbn()).getId());
        bookService.save(book);
        System.out.println("Book is update");
        return "books";
    }
    @PostMapping(value = "/update",params = "action=Delete")
    public String delete(@ModelAttribute Book book)
    {
        System.out.println(book);
        bookService.delete(book.getIsbn());
        System.out.println("book is delete");
        return "bookUpdate";
    }
    @GetMapping("/view")
    public String view(Model model,@RequestParam("isbn") String isbn)
    {
        Book book = bookService.findByIsbn(isbn);
        model.addAttribute("book",book);
        return "bookView";
    }

    @PostMapping("/addToCart")
    public String create(@RequestParam("isbn")String isbn)
    {
        bookService.addToCart(isbn);
        return "redirect:/home" ;
    }
    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("isbn") String isbn) {
        cartService.removeBook(isbn);
        return "redirect:/home";
}}
