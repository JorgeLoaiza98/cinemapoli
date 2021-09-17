package com.example.customer;

import com.example.customer.repositories.UserRepository;
import com.example.customer.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import org.assertj.core.api.Assertions;

@DataJpaTest
public class UsersRepositoriyMockTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findUserList_return_List(){
        User user = User.builder()
                .name("James")
                .lastname("Wan")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }
}