package com.projects.bookmyshow.repositories;

import com.projects.bookmyshow.models.MovieShow;
import com.projects.bookmyshow.models.Seat;
import com.projects.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndMovieShow(List<Seat> seats, MovieShow movieShow);

    @Override
    ShowSeat save(ShowSeat showSeat);
}
