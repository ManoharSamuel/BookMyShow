package com.projects.bookmyshow.repositories;

import com.projects.bookmyshow.models.Ticket;
import com.projects.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long ticketId);

    Ticket save(Ticket ticket);
}
