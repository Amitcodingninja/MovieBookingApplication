package com.example.MovieBookingApplication.Controller;


import com.example.MovieBookingApplication.DTO.LoginRequestDTO;
import com.example.MovieBookingApplication.DTO.LoginResponseDTO;
import com.example.MovieBookingApplication.DTO.RegisterRequestDTO;
import com.example.MovieBookingApplication.Entity.User;
import com.example.MovieBookingApplication.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/registernormaluser")
    public ResponseEntity<User> registerNormalUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authenticationService.registerNormalUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){

        return ResponseEntity.ok(authenticationService.login(loginRequestDTO));
    }





}
