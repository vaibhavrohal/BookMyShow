package com.Scaler.BookMy.Show.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private LocalDateTime bookedAt;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private double amount;
}
