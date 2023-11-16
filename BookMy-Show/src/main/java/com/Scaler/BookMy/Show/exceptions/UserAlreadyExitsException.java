package com.Scaler.BookMy.Show.exceptions;

public class UserAlreadyExitsException extends RuntimeException{
    public UserAlreadyExitsException(String Message){
        super(Message);
    }
}
