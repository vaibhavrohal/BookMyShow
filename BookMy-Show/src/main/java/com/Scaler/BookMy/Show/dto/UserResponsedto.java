package com.Scaler.BookMy.Show.dto;

import com.Scaler.BookMy.Show.model.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class UserResponsedto {
    private String name;
    private String email;
    private Long iD;
    private String responsemessage;
    private List<Ticket> ticketList;
    //to change ticket to ticketResponse DTO
}
