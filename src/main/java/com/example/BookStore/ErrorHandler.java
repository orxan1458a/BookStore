package com.example.BookStore;

import com.example.BookStore.Exception.NotFoundException;
import com.example.BookStore.Model.RestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public RestErrorResponse notFoundException(NotFoundException e)
    {return  new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()
    );
    }
}
