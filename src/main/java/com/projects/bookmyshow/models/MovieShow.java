package com.projects.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{
    @ManyToOne
    private Movie movie;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
