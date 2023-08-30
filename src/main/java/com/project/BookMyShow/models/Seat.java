package com.project.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int rowVal;
    private int colVal;
    @ManyToOne
    private SeatType seatType;
    private String seatNumber;
}
