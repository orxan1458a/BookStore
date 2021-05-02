package com.example.BookStore.Service.imp;

import com.example.BookStore.Model.Enums.SessionStatus;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repository.SessionRepository;
import com.example.BookStore.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SessionServiceImp implements SessionService {
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionService sessionService;


    @Override
    public Session findActivateSession() {
        return sessionRepository.findByStatus(SessionStatus.ACTIVE) ;  }

    @Override
    public void create(User user) {
        Session session = Session
                .builder()
                .sessionId(UUID.randomUUID().toString())
                .startTime(LocalDateTime.now())
                .user(user)
                .status(SessionStatus.ACTIVE)
                .build();
        sessionRepository.save(session);
    }

    @Override
    public void update() {
        Session session = findActivateSession();
        session.setEndTime(LocalDateTime.now());
        session.setStatus(SessionStatus.EXPIRE);
        sessionRepository.save(session);

    }

    public Session find() {
        Iterable<Session> sessions = sessionRepository.findAll();

        if (sessions.iterator().hasNext())
            return sessions.iterator().next();

        return null;
    }
}