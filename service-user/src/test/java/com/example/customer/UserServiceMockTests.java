package com.example.customer;

import co.com.poli.cinema.services.UserServices;
import co.com.poli.cinema.services.UserServiceImpl;
import co.com.poli.cinema.entities.User;
import co.com.poli.cinema.repositories.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

import

@SpringBootTest
public class UserServiceMockTests{

    @Mock
    private UserRepository userRepository;
    private UserServices UserServices;

    @BeforeEach
    public void begin();
        MockitoAnnotations.initMocks(testClass:this);
        UserServices = new UserServiceImpl(userRepository);
        User user = new User.builder()
            .id(4L)
            .name("James")
            .lastname("Wan")
            .build();
        Mockito.when(userRepository.findById(4L)).thenReturn(Optional.of(user))
    }

    @Test
    public void when_findById_return_user() {
        User user1 = UserServices.findById(4L);
        Assertions.assertThat(user1.getName).isEqualTo("James");
    }
}