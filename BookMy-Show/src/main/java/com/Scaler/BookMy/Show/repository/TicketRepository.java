package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Override
    Optional<Ticket> findById(Long ticketId);

    @Override
    Ticket save(Ticket ticket);
}
