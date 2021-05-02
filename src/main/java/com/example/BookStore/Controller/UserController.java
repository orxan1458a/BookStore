package com.example.BookStore.Controller;

import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Service.SessionService;
import com.example.BookStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@SessionAttributes("user")
@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    SessionService sessionService;
    @Autowired
    UserService userService;
    @ModelAttribute
    public User user(){return  new User();}
    @PostMapping("/register")
    public String register(@ModelAttribute User user)
    {
        System.out.println(user);
        userService.register(user);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model,@RequestParam("username") String userName,@RequestParam("password") String password)
    {
    userService.login(userName,password);
    return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        System.out.println("Session sistemde yenilendi..");
        return "/home";}

}
