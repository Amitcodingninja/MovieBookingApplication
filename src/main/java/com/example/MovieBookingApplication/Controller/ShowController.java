package com.example.MovieBookingApplication.Controller;

import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import com.example.MovieBookingApplication.DTO.ShowDTO;
import com.example.MovieBookingApplication.Entity.Show;
import com.example.MovieBookingApplication.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ShowController {
    @Autowired
    private ShowService showService;


    @PostMapping("/createshow")
    public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO) {
        return ResponseEntity.ok(showService.createShow(showDTO));
    }

    public ResponseEntity<List<Show>> getAllShows(){

        return ResponseEntity.ok(showService.getAllShows());
    }


    @GetMapping("/getshowsbymovie/{id}")
    public ResponseEntity<List<Show>> getShowsByMovie(@PathVariable Long id) {

        return ResponseEntity.ok(showService.getShowByMovie(id));
    }


    @GetMapping("/getshowsbytheater")
    public ResponseEntity<List<Show>> getShowByTheater(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowByTheater(id));
    }

    @PutMapping("/updateshow/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody ShowDTO showDTO) {
        return ResponseEntity.ok(showService.updateshow(id, showDTO));

    }

    @DeleteMapping("/deleteshow/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok().build();
    }


}
