package com.projects.bookmyshow.services;

import com.projects.bookmyshow.exceptions.InvalidMovieShowException;
import com.projects.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.projects.bookmyshow.models.*;
import com.projects.bookmyshow.repositories.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ShowSeatRepository showSeatRepository;
    private final MovieShowRepository movieShowRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository,
                         MovieShowRepository movieShowRepository, SeatRepository seatRepository, 
                         UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.movieShowRepository = movieShowRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(long movieShowId, List<Long> seatIds, long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not registered in the system.");
        }

        Optional<MovieShow> movieShowOptional = movieShowRepository.findById(movieShowId);
        if (movieShowOptional.isEmpty()) {
            throw new InvalidMovieShowException("Invalid movie show.");
        }

        List<Seat> seats = seatRepository.findAllById(seatIds);

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndMovieShow(seats, movieShowOptional.get());

        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)) {
                throw new ShowSeatNotAvailableException("Seat is not available for booking.");
            }
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
        }

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setUser(userOptional.get());
        ticket.setMovieShow(movieShowOptional.get());
        ticket.setAmount(0);
        ticket.setSeats(seats);
        ticket.setTimeOfBooking(new Date());

        ticketRepository.save(ticket);

        return ticket;
    }
}
