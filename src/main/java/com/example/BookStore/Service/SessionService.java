package com.example.BookStore.Service;

import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;

public interface SessionService {
    Session findActivateSession();
    void create(User user);
    void update();
    Session find();


}
