package com.example.bookings.services;


import com.example.bookings.entities.Bookings;
import com.example.bookings.repositories.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsServices {


    private final BookingsRepository bookingsRepository;

    @Override
    public void save(Bookings bookings) {
        bookingsRepository.save(bookings);
    }

    @Override
    public void delete(Bookings bookings) {
        bookingsRepository.delete(bookings);
    }

    @Override
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }
}
