package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    Optional<ShowSeat> findById(Long showseatId);
    @Override
    ShowSeat save(ShowSeat showSeat);
}
