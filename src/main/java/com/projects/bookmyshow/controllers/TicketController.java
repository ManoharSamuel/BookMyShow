package com.projects.bookmyshow.controllers;

import com.projects.bookmyshow.dtos.BookTicketRequestDTO;
import com.projects.bookmyshow.dtos.BookTicketResponseDTO;
import com.projects.bookmyshow.models.Ticket;
import com.projects.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO) {
        BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();
        Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getMovieShowId(),
                            bookTicketRequestDTO.getSeatIds(), bookTicketRequestDTO.getUserId());
        bookTicketResponseDTO.setTicketId(ticket.getId());
        return bookTicketResponseDTO;
    }
}
