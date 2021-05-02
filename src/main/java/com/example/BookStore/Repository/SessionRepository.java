package com.example.BookStore.Repository;

import com.example.BookStore.Model.Enums.SessionStatus;
import com.example.BookStore.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
Session findByStatus(SessionStatus status);

}
