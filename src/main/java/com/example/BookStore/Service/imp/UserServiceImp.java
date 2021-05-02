package com.example.BookStore.Service.imp;

import com.example.BookStore.Model.Enums.Role;
import com.example.BookStore.Exception.NotFoundException;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repository.SessionRepository;
import com.example.BookStore.Repository.UserRepository;
import com.example.BookStore.Service.SessionService;
import com.example.BookStore.Service.UserService;
import com.example.BookStore.util.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionService sessionService;
    @Override
    public void register(User user)
    {
        if(!user.getPassword().equals(user.getConfirmPassword()))
            throw new IllegalArgumentException("Password mismatch");
        String hashPassword = PasswordHasher.getMd5(user.getPassword());
        user.setRole(Role.User);
        user.setPassword(hashPassword);
        user.setConfirmPassword(hashPassword);
        userRepository.save(user);
    }

    @Override
    public User login(String userName, String password) {
        User user;


        Session session = sessionService.findActivateSession();
        if(session!=null)    return session.getUser();

        try
        {
            user = userRepository.findByUserName(userName);
        }catch (Exception e){throw new NotFoundException("Zehmet olmasa login xanasini doldurun;");}
            if (user == null)
            {throw new NotFoundException("Bele login movcud deyil;");}
//        if(!userName.equals(userRepository.findByUserName(userName)))
//        throw new NotFoundException("BAZADA BELE USERNAME MOVCUD DEYIL...");

    if(password.isEmpty())
    {
        System.out.println("Zehmet olmasa xanani doldur...");
        throw new NotFoundException("Zehmet olmasa xanani doldurun");
    }
        String hashPassword = PasswordHasher.getMd5(password);

        if (!hashPassword.equals(userRepository.findByUserName(userName).getPassword()))
        {  System.out.println("Parol sehfdi");
        throw new NotFoundException("Parol yanlishdir.");}
            sessionService.create(user);
        return user;


    }

    @Override
    public void findByUserName(String userName) {
        findByUserName(userName);
    }

    @Override
    public void logout() {
        sessionService.update();
    }


}
