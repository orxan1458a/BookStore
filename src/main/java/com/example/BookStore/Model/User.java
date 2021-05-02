package com.example.BookStore.Model;

import com.example.BookStore.Model.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Role role;

}
