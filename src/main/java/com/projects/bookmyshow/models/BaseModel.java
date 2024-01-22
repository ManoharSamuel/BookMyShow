package com.projects.bookmyshow.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.EventListener;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(EventListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @CreatedDate
    @Temporal(value = TemporalType.DATE)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value =TemporalType.DATE)
    private Date updatedAt;
}
