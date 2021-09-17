package com.example.customer;

import com.example.customer.services.UserServices;
import com.example.customer.services.UserServiceImpl;
import com.example.customer.entities.User;
import com.example.customer.repositories.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

@SpringBootTest
public class UserServiceMockTests{

    @Mock
    private UserRepository userRepository;
    private UserServices UserServices;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        UserServices = new UserServiceImpl(userRepository);
        User user =  User.builder()
            .id(4L)
            .name("James")
            .lastname("Wan")
            .build();
        Mockito.when(userRepository.findById(4L)).thenReturn(Optional.of(user));
    }

    @Test
    public void when_findById_return_user() {
        User user1 = UserServices.findById(4L);
        Assertions.assertThat(user1.getName()).isEqualTo("James");
    }
}