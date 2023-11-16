package com.Scaler.BookMy.Show.controller;

import com.Scaler.BookMy.Show.dto.TicketRequestDto;
import com.Scaler.BookMy.Show.exceptions.TicketNotFoundException;
import com.Scaler.BookMy.Show.model.Ticket;
import com.Scaler.BookMy.Show.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;
   @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    Ticket bookTicket(TicketRequestDto ticketRequestDto){
       try {
           return ticketService.bookTicket(ticketRequestDto.getUserId(), ticketRequestDto.getShowseatIdList(), ticketRequestDto.getShowId());

       }
       catch(Exception e){
           throw new TicketNotFoundException("ticket can not be booked");
       }
    }

}
