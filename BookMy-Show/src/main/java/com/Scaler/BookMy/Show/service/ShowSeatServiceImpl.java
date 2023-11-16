package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.exceptions.ShowSeatNotFoundException;
import com.Scaler.BookMy.Show.model.ShowSeat;
import com.Scaler.BookMy.Show.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowSeatServiceImpl implements ShowSeatService{
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Override
    public List<ShowSeat> getshowSeats(List<Long> showSeatiDs) {
        List<ShowSeat> showSeatList=new ArrayList<>();
        for (Long i:showSeatiDs){
            Optional<ShowSeat> OptionalShowSeat=showSeatRepository.findById(i);
            if (OptionalShowSeat.isEmpty()){
                throw new ShowSeatNotFoundException("ShowSeat not found with id "+i);
            }
            ShowSeat showSeat=OptionalShowSeat.get();
            showSeatList.add(showSeat);
        }
        return showSeatList;
    }

    @Override
    public ShowSeat getshowSeat(Long showSeatiD) {
        Optional<ShowSeat> OptionalShowSeat=showSeatRepository.findById(showSeatiD);
        if (OptionalShowSeat.isEmpty()){
            throw new ShowSeatNotFoundException("ShowSeat not found with id "+showSeatiD);
        }
        return OptionalShowSeat.get();

    }

    @Override
    public List<ShowSeat> updateShowSeats(List<Long> showseatiDs) {
        return null;
    }

    @Override
    public ShowSeat updateShowSeat(Long showSeatiD) {
        return null;
    }
}
