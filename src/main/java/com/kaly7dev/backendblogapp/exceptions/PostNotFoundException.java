package com.kaly7dev.backendblogapp.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String exMessage){
        super(exMessage);
    }
    public PostNotFoundException(String exMessage, Exception exception){
        super(exMessage, exception);
    }
}
