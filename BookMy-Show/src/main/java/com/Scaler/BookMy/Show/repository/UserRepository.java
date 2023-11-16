package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long userId);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndName(String email,Long userId);
    @Override
    User save(User user);

}
