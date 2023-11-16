package com.Scaler.BookMy.Show.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
private int row;
private int col;
private String seatNumber;
@ManyToOne
private SeatType seatType;
}
