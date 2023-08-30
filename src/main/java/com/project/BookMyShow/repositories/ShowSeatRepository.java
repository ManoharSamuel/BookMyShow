package com.project.BookMyShow.repositories;

import com.project.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long showSeatId);

    @Override
    ShowSeat save(ShowSeat showSeat);
}
