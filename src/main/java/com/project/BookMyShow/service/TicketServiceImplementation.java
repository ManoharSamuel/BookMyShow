package com.project.BookMyShow.service;

import com.project.BookMyShow.exceptions.TicketNotFoundException;
import com.project.BookMyShow.exceptions.UserNotFoundException;
import com.project.BookMyShow.models.*;
import com.project.BookMyShow.repositories.TicketRepository;
import com.project.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketServiceImplementation implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long movieShowId) {
        return null;
    }

    @Override
    public Ticket cancelTicket(Long userId, Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isEmpty()) {
            throw new TicketNotFoundException("Ticket does not exist with the given ticketId of "+ticketId);
        }
        Ticket ticket = optionalTicket.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for (ShowSeat showSeat : ticket.getShowSeats()) {
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        }
        for (Payment payment : ticket.getPayments()) {
            int ref =  payment.getRefNumber();
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        Optional<User> optionalUserOne = userRepository.findById(fromUserId);
        Optional<User> optionalUserTwo = userRepository.findById(toUserId);
        if (optionalTicket.isEmpty()) {
            throw new TicketNotFoundException("Ticket does not exist with the given ticketId of "+ticketId);
        }
        if (optionalUserOne.isEmpty() || optionalUserTwo.isEmpty()) {
            throw new UserNotFoundException("User does not exist with the given userId.");
        }

        Ticket ticket = optionalTicket.get();

        User fromUser = optionalUserOne.get();
        List<Ticket> bookedTickets = fromUser.getTickets();
        bookedTickets.remove(ticket);
        fromUser.setTickets(bookedTickets);
        userRepository.save(fromUser);

        User toUser = optionalUserTwo.get();
        bookedTickets = toUser.getTickets();
        bookedTickets.add(ticket);
        toUser.setTickets(bookedTickets);
        userRepository.save(toUser);

        ticket.setUser(toUser);
        return ticketRepository.save(ticket);
    }
}
