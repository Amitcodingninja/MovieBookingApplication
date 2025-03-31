package com.example.MovieBookingApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;
    private String theaterLocation;
    private Integer theaterCapacity;
    private String theaterScreenType;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    private List<Show> show;
}
