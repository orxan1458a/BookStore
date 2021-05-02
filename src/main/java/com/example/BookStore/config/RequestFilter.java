package com.example.BookStore.config;
import com.example.BookStore.Model.Enums.Role;
import com.example.BookStore.Model.Session;
import com.example.BookStore.Service.SessionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    private SessionService sessionService;

    RequestFilter(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        Session session = sessionService.findActivateSession();

        if (session == null)
            res.addHeader("role", Role.User.name());
        else res.addHeader("role", session.getUser().getRole().name());

        filterChain.doFilter(req, res);
    }
}