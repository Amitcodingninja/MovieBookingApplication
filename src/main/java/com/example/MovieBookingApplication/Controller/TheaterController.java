package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.DTO.TheaterDTO;
import com.example.MovieBookingApplication.Entity.Theater;
import com.example.MovieBookingApplication.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addtheater")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterDTO theaterDTO) {
        return ResponseEntity.ok(theaterService.addTheater(theaterDTO));
    }

    @GetMapping("/gettheaterbylocation")
    public ResponseEntity<List<Theater>> getTheaterByLocation(@RequestParam String location) {
        return ResponseEntity.ok(theaterService.getTheaterByLocation(location));

    }

    @PutMapping("/updatetheater/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody TheaterDTO theaterDTO) {
        return ResponseEntity.ok(theaterService.updateTheater(id, theaterDTO));
    }

    @DeleteMapping("/deletetheater/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return ResponseEntity.ok().build();
    }


}
