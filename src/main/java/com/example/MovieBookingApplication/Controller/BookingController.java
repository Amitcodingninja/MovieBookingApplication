package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.DTO.BookingDTO;
import com.example.MovieBookingApplication.Entity.Booking;
import com.example.MovieBookingApplication.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createbooking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    @GetMapping("/getuserbookings/{id}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getUserBooking(id));
    }

    @GetMapping("getshowsbookings/{id}")
    public ResponseEntity<List<Booking>> getShowBookings(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getShowBookings(id));
    }

    @PutMapping("{id}/confirm")
    public ResponseEntity<Booking> confirmBooking(@PathVariable Long id) {

        return ResponseEntity.ok(bookingService.confirmBooking(id));
    }


    @PutMapping("{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

//    @GetMapping("/getbookingbystatus/{bookingStatus}")
//    public ResponseEntity<List<Booking>> getBookingByStatus(@PathVariable BookingStatus bookingStatus) {
//
//        return ResponseEntity.ok(bookingStatus.getBookingByStatus(bookingStatus));
//    }


}
