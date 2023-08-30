package com.project.BookMyShow.models;

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
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @OneToMany
    private List<ShowSeat> showSeats;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;

}
