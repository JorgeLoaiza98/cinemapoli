package com.example.customer;

import co.com.poli.cinema.repositories.UserRepository;
import co.com.poli.cinema.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class UsersRepositoriyMockTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findUserList_return_List<User>(){
        User user = new User.builder()
                .name("James")
                .lastname("Wan")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findUserList(user);
        Assertions.assertThat(users.sixe()).isEqualTo(2);
    }
}