package com.example.BookStore.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_books",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books = new ArrayList<>();
    @ManyToOne
    private User user;
    private LocalDateTime dateTime;
}
