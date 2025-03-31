package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.DTO.RegisterRequestDTO;
import com.example.MovieBookingApplication.Entity.User;
import com.example.MovieBookingApplication.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// 1st User will be admin by SQL Command only
@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/registeradminuser")
    public ResponseEntity<User> registerNormalUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authenticationService.registerAdminUser(registerRequestDTO));
    }



}
