package com.example.bookings.services;

import com.example.bookings.entities.Bookings;

import java.util.List;

public interface BookingsServices {

    void save(Bookings bookings);
    void delete(Bookings bookings);
    List<Bookings> findAll();
    Bookings findById(Long id);

}
