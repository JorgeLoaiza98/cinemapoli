package com.example.bookings.controller;


import com.example.bookings.entities.Bookings;
import com.example.bookings.services.BookingsServices;
import co.com.poli.cinema.utils.ErrorMessage;
import co.com.poli.cinema.utils.Response;
import co.com.poli.cinema.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingsController
{

    private final BookingsServices bookingsServices;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        bookingsServices.save(bookings);
        return builder.success(bookings);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Bookings> delete(@PathVariable("id") Long id) {
        Bookings bookings = bookingsServices.findById(id);
        if (bookings == null) {
            return ResponseEntity.notFound().build();

        }
        bookingsServices.delete(bookings);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping
    public ResponseEntity<List<Bookings>> findAll(){
        List<Bookings> bookings = bookingsServices.findAll();
        if(bookings.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> findById(@PathVariable("id") Long id){
        Bookings bookings = bookingsServices.findById(id);
        if(bookings==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/user_id/{user_id}")
    public Response findByUser_id(@PathVariable("user_id") Long user_id, BindingResult result){
        Bookings bookings = bookingsServices.findByUser_id(user_id);
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        return builder.success(bookings);
    }



    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }
}
