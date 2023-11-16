package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.model.Seat;
import com.Scaler.BookMy.Show.model.ShowSeat;

import java.util.List;

public interface ShowSeatService {
    List<ShowSeat> getshowSeats(List<Long> showSeatiDs);
      ShowSeat getshowSeat(Long showSeatiD);

      List<ShowSeat> updateShowSeats(List<Long> showseatiDs);
      ShowSeat updateShowSeat(Long showSeatiD);

}
