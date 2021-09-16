package com.example.showtimes.controller;


import com.example.showtimes.services.ShowTimesServices;
import com.example.showtimes.entities.ShowTimes;
import com.example.showtimes.utils.ErrorMessage;
import com.example.showtimes.utils.Response;
import com.example.showtimes.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowTimesController {


    private final ShowTimesServices showtimesServices;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody ShowTimes showtimes, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        showtimesServices.save(showtimes);
        return builder.success(showtimes);
    }


    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id, BindingResult result) {
        ShowTimes showtimes = showtimesServices.findById(id);
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        showtimesServices.delete(showtimes);
        return builder.success(showtimes);
    }

    @GetMapping
    public Response findAll(BindingResult result){
        List<ShowTimes> showtimes = showtimesServices.findAll();
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        return builder.success(showtimes);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id, BindingResult result){
        ShowTimes showtimes = showtimesServices.findById(id);
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        return builder.success(showtimes);
    }

    @PutMapping("/{id}")
    public Response updateShowTime(@Valid @PathVariable(value = "id") Long showtimeId,  @RequestBody ShowTimes showtimesDetails, BindingResult result) {
        ShowTimes showtimes = showtimesServices.findById(showtimeId);
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        showtimes.setFecha_funcion(showtimesDetails.getFecha_funcion());

        showtimesServices.save(showtimes);
        return builder.success(showtimes);
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
