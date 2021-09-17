package com.cinema;

import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.repositories.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class MovieRepositoryMockTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findMovieList_return_List(){
        Movie movie = Movie.builder()
                .title("It")
                .director("James Wan")
                .rating(3)
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findAll();
        Assertions.assertThat(movies.size()).isEqualTo(1);
    }
}
