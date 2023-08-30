package com.project.BookMyShow.service;

import com.project.BookMyShow.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long movieShowId);
    Ticket cancelTicket(Long userId, Long ticketId);
    Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId);
}
