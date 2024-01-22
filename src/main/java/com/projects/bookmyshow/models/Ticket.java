package com.projects.bookmyshow.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private MovieShow movieShow;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Payment> payments;
    private int amount;
    @Enumerated(value = EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    private Date timeOfBooking;
}
