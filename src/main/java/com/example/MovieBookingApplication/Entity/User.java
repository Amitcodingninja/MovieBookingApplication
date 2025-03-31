package com.example.MovieBookingApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {
    private Long id;
    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER) // It will create a new table like user and roles
    private Set<String> roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().
                map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
