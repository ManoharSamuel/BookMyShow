package com.projects.bookmyshow.repositories;

import com.projects.bookmyshow.models.Seat;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Override
    Optional<Seat> findById(Long aLong);

    @Override
    List<Seat> findAllById(Iterable<Long> seatIds);

    Seat save(Seat seat);
}
