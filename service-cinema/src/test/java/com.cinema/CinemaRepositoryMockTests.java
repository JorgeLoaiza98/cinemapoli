package com.cinema;

import co.com.poli.cinema.repositories.MovieRepository;
import co.com.poli.cinema.entities.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class CinemaRepositoriyMockTest{

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findMovieList_return_List<Movie>(){
        Movie movie = new Movie.builder()
                .title("It")
                .director("James Wan")
                .rating(3)
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findMovieList(movie);
        Assertions.assertThat(movies.sixe()).isEqualTo(2);
    }
}