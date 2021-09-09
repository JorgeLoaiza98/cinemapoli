package co.com.poli.cinema.services;

import co.com.poli.cinema.entities.User;

import java.util.List;

public interface UserServices {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);

}
