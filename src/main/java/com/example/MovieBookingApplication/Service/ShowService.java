package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.DTO.ShowDTO;
import com.example.MovieBookingApplication.Entity.Booking;
import com.example.MovieBookingApplication.Entity.Movie;
import com.example.MovieBookingApplication.Entity.Show;
import com.example.MovieBookingApplication.Entity.Theater;
import com.example.MovieBookingApplication.Repository.MovieRepository;
import com.example.MovieBookingApplication.Repository.ShowRepository;
import com.example.MovieBookingApplication.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public Show createShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId()).orElseThrow(() -> new RuntimeException("No Movie Found " + showDTO.getMovieId()));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId()).orElseThrow(() -> new RuntimeException("No Theater Found for id " + showDTO.getTheaterId()));

        Show show = new Show();
        show.setShowTiime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice());
        show.setMovie(movie);
        show.setTheater(theater);
        return showRepository.save(show);


    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getShowByMovie(Long movieid) {
        Optional<List<Show>> showList = showRepository.findByMovieId(movieid);
        if (showList.isPresent()) {
            return showList.get();
        } else throw new RuntimeException("No shows available for the movie");

    }

    public List<Show> getShowByTheater(Long theaterid) {
        Optional<List<Show>> showListBox = showRepository.findByTheaterId(theaterid);

        if (showListBox.isPresent()) {
            return showListBox.get();
        } else throw new RuntimeException("No Show available for the Theater");
    }

    public Show updateshow(Long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No Show available for the id " + id));


        Movie movie = movieRepository.findById(showDTO.getMovieId()).
                orElseThrow(() -> new RuntimeException("No Movie Found for id " + showDTO.getMovieId()));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(() -> new RuntimeException("No Theater Found for id " + showDTO.getTheaterId()));

        show.setShowTiime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice());
        show.setMovie(movie);
        show.setTheater(theater);

        return showRepository.save(show);


    }

    public void deleteShow(Long id) {
        if (!showRepository.existsById(id)) {
            throw new RuntimeException("No Show available for the id " + id);
        }
        List<Booking> bookings = showRepository.findById(id).get().getBookings();

        if (!bookings.isEmpty()) {
            throw new RuntimeException("Can't delete show with existing booking ");
        }

        showRepository.deleteById(id);
    }


}
