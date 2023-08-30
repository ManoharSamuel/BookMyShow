package com.project.BookMyShow.repositories;

import com.project.BookMyShow.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {

    @Override
    Optional<SeatType> findById(Long seatTypeId);

    @Override
    SeatType save(SeatType seatType);
}
