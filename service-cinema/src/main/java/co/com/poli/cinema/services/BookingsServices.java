package co.com.poli.cinema.services;

import co.com.poli.cinema.entities.Bookings;

import java.util.List;

public interface BookingsServices {

    void save(Bookings bookings);
    void delete(Bookings bookings);
    List<Bookings> findAll();
    Bookings findById(Long id);

}
