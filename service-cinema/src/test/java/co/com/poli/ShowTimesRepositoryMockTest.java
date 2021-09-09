package co.com.poli;

import co.com.poli.cinema.entities.ShowTimes;
import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.repositories.ShowTimesRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ShowTimesRepositoryMockTest {

@Autowired
    private ShowTimesRepository showTimesRepository;

@Test
    public void when_findByMovie_return_ListShowTimes(){
    ShowTimes showtime = ShowTimes.builder()
            .date("05/08/2015")
            .movie(Movie.builder().id(2L).build())
            .build();
    showTimesRepository.save(showtime);
    List<ShowTimes> showtimes = showTimesRepository.findByMovie(showtime.getMovie());
    Assertions.assertThat(showtimes.size()).isEqualTo(1);
}

}
