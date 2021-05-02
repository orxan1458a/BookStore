package com.example.BookStore.Repository;

import com.example.BookStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
     User findByUserName(String userName);

}
