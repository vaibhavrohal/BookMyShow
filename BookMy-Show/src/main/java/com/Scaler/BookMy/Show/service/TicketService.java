package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.model.Seat;
import com.Scaler.BookMy.Show.model.ShowSeat;
import com.Scaler.BookMy.Show.model.Ticket;
import com.Scaler.BookMy.Show.model.User;

import java.util.List;

public interface    TicketService {
    Ticket bookTicket(Long userId, List<Long> ShowSeatIds , Long showId);//check if showId required
    Ticket cancelTicket(Long ticketId);
    Ticket transferTicket(Long fromUserId,Long toUserId, Long ticketId);
}
