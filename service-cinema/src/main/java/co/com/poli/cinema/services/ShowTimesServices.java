package co.com.poli.cinema.services;

import co.com.poli.cinema.entities.ShowTimes;

import java.util.List;

public interface ShowTimesServices {


    void save(ShowTimes showtimes);
    void delete(ShowTimes showtimes);
    List<ShowTimes> findAll();
    ShowTimes findById(Long id);
}
