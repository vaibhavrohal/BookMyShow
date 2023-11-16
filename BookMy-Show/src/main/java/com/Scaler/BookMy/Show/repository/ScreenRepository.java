package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ScreenRepository extends JpaRepository<Screen,Long> {

    @Override
    Optional<Screen> findById(Long screenId);
    @Override
    Screen save(Screen screen);
}
