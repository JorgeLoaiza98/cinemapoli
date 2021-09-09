package co.com.poli.cinema.services;


import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.entities.ShowTimes;
import co.com.poli.cinema.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieServices{


    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {movieRepository.save(movie);}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {movieRepository.delete(movie);}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
