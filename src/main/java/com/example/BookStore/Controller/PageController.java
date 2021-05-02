package com.example.BookStore.Controller;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repository.CartRepository;
import com.example.BookStore.Service.BookService;
import com.example.BookStore.Service.CartService;
import com.example.BookStore.Service.SessionService;
import com.example.BookStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    UserService userService;
    @Autowired
    SessionService sessionService;
    @Autowired
    BookService bookService;
    @Autowired
    CartService cartService;

    @GetMapping({"/","/home"})
    public String home(Model model)
    {
     List<Book> books=bookService.findAll();
     model.addAttribute("books",books);
        return "home";
    }

    @GetMapping(value="/register")
    public String registerFrom(Model model){
        model.addAttribute("user",new User());
        System.out.println(model);
        return "register";
    }
    @GetMapping({"/login"})
    public String login()
    {
        return "/login";
    }

    @GetMapping("/bookCreate")
    public String bookCreate(Model model){
        model.addAttribute("book",new Book());
        return "bookCreate";}

    @GetMapping("/books")
    public String books(Model model)
    {
        List<Book> books =bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/bookDelete")
    public String bookDelete(Model model)
    {
        model.addAttribute("book",new Book());
        System.out.println(model);
        return "bookDelete";
    }
    @GetMapping("bookUpdate")
    public String bookUpdate(Model model)
    {
        model.addAttribute("book",new Book());
        return "bookUpdate";
    }
    @GetMapping("/bookManagement")
    public String bookManagement()
    {
        return "bookManagement";
    }

    @GetMapping("/cartPage")
    public String  cartPage(Model model)
    {
        Cart cart =cartService.findActiveCart();
        model.addAttribute("cart",cart);
        return  "cartPage";





    }

}
