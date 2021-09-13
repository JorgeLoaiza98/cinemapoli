package com.example.showtimes.repositories;



import com.example.showtimes.entities.ShowTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimesRepository extends JpaRepository<ShowTimes,Long> {


}
