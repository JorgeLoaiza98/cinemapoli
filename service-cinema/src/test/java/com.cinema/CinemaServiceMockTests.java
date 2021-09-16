package com.cinema;

import co.com.poli.cinema.services.MovieServices;
import co.com.poli.cinema.services.MovieServiceImpl;
import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.repositories.MovieRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

import

@SpringBootTest
public class CinemaServiceMockTest{

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin();
        MockitoAnnotations.initMocks(testClass:this);
        movieService = new MovieServiceImpl(movieRepository);
        Movie movie = new Movie.builder()
                .id(4L)
            .title("It")
            .director("James Wan")
            .rating(3)
            .build();
        Mockito.when(movieRepository.findById(4L)).thenReturn(Optional.of(movie))
    }

    @Test
    public void when_findById_return_Movie() {
        Movie movie1 = movieService.findById(4L);
        Assertions.assertThat(movie1.getTitle).isEqualTo("It");
    }
}