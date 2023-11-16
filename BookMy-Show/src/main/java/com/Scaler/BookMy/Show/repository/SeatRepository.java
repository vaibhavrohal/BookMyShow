package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Override
    Optional<Seat> findById(Long seatId);
    @Override
    Seat save(Seat seat);

}
