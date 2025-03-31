package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.DTO.MovieDTO;
import com.example.MovieBookingApplication.Entity.Movie;
import com.example.MovieBookingApplication.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addmovie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO) {

        return ResponseEntity.ok(movieService.addMovie(movieDTO));
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/getmoviesbygenre")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/getmoviesbylanguage")
    public ResponseEntity<List<Movie>> getMoviesBLanguage(@RequestParam String language) {
        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/getmoviesbytitle")

    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @PutMapping("/updatemovie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return ResponseEntity.ok(movieService.updateMovie(id, movieDTO));
    }

    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);

        return ResponseEntity.ok().build();
    }

}
