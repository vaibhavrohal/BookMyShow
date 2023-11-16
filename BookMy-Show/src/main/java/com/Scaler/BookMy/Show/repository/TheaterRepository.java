package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Theater;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface TheaterRepository extends JpaRepository<Theater,Long> {
    @Override
    Optional<Theater> findById(Long theaterId);

    @Override
   Theater save(Theater theater);
}
