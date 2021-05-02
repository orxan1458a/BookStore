package com.example.BookStore.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super (message);
    }
}
