package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.DTO.TheaterDTO;
import com.example.MovieBookingApplication.Entity.Theater;
import com.example.MovieBookingApplication.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater addTheater(TheaterDTO theaterDTO) {
        Theater theater = new Theater();
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());
        theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
        return theaterRepository.save(theater);
    }

    public List<Theater> getTheaterByLocation(String location) {
        Optional<List<Theater>> listOfTheaterBox = Optional.of(theaterRepository.findByTheaterLocation(location));
        if (listOfTheaterBox.isPresent() && !listOfTheaterBox.get().isEmpty()) {
            return listOfTheaterBox.get();
        } else {
            throw new RuntimeException("No theater found for the location entered " + location);
        }
    }

    public Theater updateTheater(Long id, TheaterDTO theaterDTO) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No theater found for the id " + id));
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());
        theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
        return theaterRepository.save(theater);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}