package com.example.bookings.client;

import co.com.poli.cinema.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@FeignClient(name = "service-user")
public interface UserClient {

    @GetMapping("/{id}")
     Response findById(@Valid @PathVariable("id") Long id);


}
