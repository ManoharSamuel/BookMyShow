package com.projects.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refId;
    private int amount;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentType paymentType;
    private Date timeOfPayment;
}
