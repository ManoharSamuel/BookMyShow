package com.projects.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private long movieShowId;
    private List<Long> seatIds;
    private long userId;
}
