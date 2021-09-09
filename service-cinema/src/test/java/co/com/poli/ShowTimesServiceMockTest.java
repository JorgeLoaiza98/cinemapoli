package co.com.poli;

import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.entities.ShowTimes;
import co.com.poli.cinema.repositories.ShowTimesRepository;
import co.com.poli.cinema.services.ShowTimesServices;
import co.com.poli.cinema.services.ShowTimesServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ShowTimesServiceMockTest {

    @Mock
    private ShowTimesRepository showtimesRepository;
    private ShowTimesServices showtimesServices;

    @BeforeEach
    public void begin()
    {
        MockitoAnnotations.initMocks(this);
        showtimesServices = new ShowTimesServiceImpl(showtimesRepository);

        ShowTimes showtime = ShowTimes.builder()
                .id(4L)
                .date("05/08/2015")
                .movie(Movie.builder().id(2L).build())
                .build();

        Mockito.when(showtimesRepository.findById(4L)).thenReturn(Optional.of(showtime));

    }

    @Test
    public void when_findByID(){
        ShowTimes showtime = showtimesServices.findById(4L);
        Assertions.assertThat(showtime.getDate()).isEqualTo("05/08/2015");

    }


}
