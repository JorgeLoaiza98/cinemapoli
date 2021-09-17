package com.example.customer;

import com.example.customer.entities.User;
import com.example.customer.repositories.UserRepository;
import com.example.customer.services.UserServiceImpl;
import com.example.customer.services.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceMockTests{
    @Mock
    private UserRepository userRepository;
    private UserServices userService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);

        User user = User.builder()
                .id(3L)
                .name("Alex")
                .lastname("Gomez")
                .build();

        Mockito.when(userRepository.findById(3L))
                .thenReturn(Optional.of(user));
    }
}