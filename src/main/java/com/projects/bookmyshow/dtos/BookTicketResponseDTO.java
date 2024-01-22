package com.projects.bookmyshow.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private long ticketId;
    private int responseCode;
    private String responseMessage;
    private int amount;
    private List<String> seatNumbers;
    private String screenName;
}
