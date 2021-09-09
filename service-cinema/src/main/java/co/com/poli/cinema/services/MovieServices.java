package co.com.poli.cinema.services;

import co.com.poli.cinema.entities.Movie;

import java.util.List;

public interface MovieServices {

    void save(Movie movie);
    void delete(Movie movie);
    List<Movie> findAll();
    Movie findById(Long id);

}
