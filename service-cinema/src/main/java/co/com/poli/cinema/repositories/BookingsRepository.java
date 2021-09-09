package co.com.poli.cinema.repositories;


import co.com.poli.cinema.entities.Bookings;
import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.entities.User;
import co.com.poli.cinema.entities.ShowTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Long> {
    List<Bookings> findByUser(User user);

}
