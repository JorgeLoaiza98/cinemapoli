package com.cinema;
import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.services.MovieServiceImpl;
import co.com.poli.cinema.services.MovieServices;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.poli.cinema.repositories.MovieRepository;
import org.mockito.Mock;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieServices movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .id(3L)
                .title("PruebaTestService")
                .director("DirectorTestService")
                .rating(3)
                .build();

        Mockito.when(movieRepository.findById(3L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie = movieService.findById(3L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("PruebaTestService");
    }
}
