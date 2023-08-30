package com.project.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private MovieShow movieShow;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Payment> payments;
    private double price;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private Date bookedAt;
}
