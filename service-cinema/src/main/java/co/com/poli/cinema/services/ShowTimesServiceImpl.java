package co.com.poli.cinema.services;
import co.com.poli.cinema.repositories.ShowTimesRepository;
import co.com.poli.cinema.entities.ShowTimes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimesServiceImpl implements ShowTimesServices{

    private final ShowTimesRepository showtimesRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowTimes showtimes) {
        showtimesRepository.save(showtimes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ShowTimes showtimes) {
        showtimesRepository.delete(showtimes);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShowTimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ShowTimes findById(Long id) {
        return showtimesRepository.findById(id).orElse(null);
    }
}

