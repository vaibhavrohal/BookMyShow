package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Movie;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Override
    Optional<Movie> findById(Long movieId);
    @Override
    Movie save(Movie movie);
}
