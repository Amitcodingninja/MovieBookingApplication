package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
   Optional<List<Movie>> findByGenre(String genre);
   Optional<List<Movie>>  findByLanguage(String language);
   Optional<Movie> findByName(String title);
}
