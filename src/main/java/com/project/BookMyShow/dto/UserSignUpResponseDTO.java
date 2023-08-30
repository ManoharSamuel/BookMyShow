package com.project.BookMyShow.dto;

import com.project.BookMyShow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String responseCode;
    private String responseMessage;
    private List<Ticket> tickets;
}
