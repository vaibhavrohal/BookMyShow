package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    @Override
    Optional<Show> findById(Long showId);
    @Override

    Show save(Show show);
}
