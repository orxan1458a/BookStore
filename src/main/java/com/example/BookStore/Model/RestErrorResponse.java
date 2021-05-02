package com.example.BookStore.Model;

public class RestErrorResponse {
    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestErrorResponse(int code, String message){
        this.code=code;
        this.message=message;

    }
}
