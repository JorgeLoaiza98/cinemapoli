package co.com.poli.cinema.repositories;

import co.com.poli.cinema.entities.ShowTimes;
import co.com.poli.cinema.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimesRepository  extends JpaRepository<ShowTimes,Long> {
    List<ShowTimes> findByMovie(Movie movie);


}
