package com.example.MovieBookingApplication.Repository;
import com.example.MovieBookingApplication.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    List<Theater> findByTheaterLocation(String theaterLocation);
}