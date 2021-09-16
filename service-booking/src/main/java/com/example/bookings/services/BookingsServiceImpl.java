package com.example.bookings.services;


import com.example.bookings.client.MovieClient;
import com.example.bookings.client.UserClient;
import com.example.bookings.entities.Bookings;
import com.example.bookings.model.User;
import com.example.bookings.repositories.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsServices {

    private final UserClient userClient;
    private final MovieClient movieClient;
    private final BookingsRepository bookingsRepository;

    @Override
    public void save(Bookings bookings) {
        bookingsRepository.save(bookings);
    }

    @Override
    public void delete(Bookings bookings) {
        bookingsRepository.delete(bookings);
    }

    @Override
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }

    @Override
    public Bookings findByUser_id(Long user_id)
    {
        Bookings bookings= bookingsRepository.findByUser_id(user_id);
        ModelMapper modelMapper = new ModelMapper();
        User user =
                modelMapper.map(
                        userClient.findById(bookings.getUser_id()).getData(),
                        User.class);
        bookings.setUser(user);

        return bookingsRepository.findByUser_id(user_id);
    }



}
