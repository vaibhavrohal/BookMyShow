package com.Scaler.BookMy.Show.exceptions;

import com.Scaler.BookMy.Show.repository.TicketRepository;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(String message){
        super (message);
    }
}
