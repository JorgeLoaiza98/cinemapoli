package com.example.customer.services;

import java.util.List;
import com.example.customer.entities.User;

public interface UserServices {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);

}
