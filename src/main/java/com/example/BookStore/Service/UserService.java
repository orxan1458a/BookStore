package com.example.BookStore.Service;

import com.example.BookStore.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     void register(User user);
     User login(String userName, String password);
     void findByUserName(String userName);
     void logout();

}
