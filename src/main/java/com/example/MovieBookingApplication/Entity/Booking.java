package com.example.MovieBookingApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"user", "show"})
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfSeats;

    private LocalDateTime bookingTime;

    private Double price;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    // Seat Numbers Collection
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "booking_seat_numbers", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_number")
    private List<String> seatNumbers;

    // User Mapping
    @ManyToOne(fetch = FetchType.LAZY) // Prefer Lazy for better performance
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Show Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
}
