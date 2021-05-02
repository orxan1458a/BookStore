package com.example.BookStore.Repository;


import com.example.BookStore.Model.Order;
import com.example.BookStore.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);
}
