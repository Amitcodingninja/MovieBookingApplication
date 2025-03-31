package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<List<Show>> findByMovieId(Long movieId);
    Optional<List<Show>> findByTheaterId(Long theaterid);

}
