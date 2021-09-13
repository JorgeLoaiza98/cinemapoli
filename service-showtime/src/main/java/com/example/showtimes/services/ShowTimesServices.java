package com.example.showtimes.services;

import java.util.List;

import com.example.showtimes.entities.ShowTimes;
public interface ShowTimesServices {


    void save(ShowTimes showtimes);
    void delete(ShowTimes showtimes);
    List<ShowTimes> findAll();
    ShowTimes findById(Long id);
}
