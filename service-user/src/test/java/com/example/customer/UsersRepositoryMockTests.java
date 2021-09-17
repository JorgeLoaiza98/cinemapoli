package com.example.customer;

import com.example.customer.entities.User;
import com.example.customer.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class UsersRepositoryMockTests{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findUserList_return_List(){
        User user = User.builder()
                .id(3L)
                .name("Maria")
                .lastname("Prueba")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(1);
    }
}