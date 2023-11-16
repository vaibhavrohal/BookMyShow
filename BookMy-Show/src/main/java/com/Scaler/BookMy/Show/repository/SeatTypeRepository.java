package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {
    @Override
    Optional<SeatType> findById(Long seattypeId);
    @Override
    SeatType save(SeatType seatType);
}
