package co.com.poli.cinema.controller;


import co.com.poli.cinema.entities.Movie;
import co.com.poli.cinema.services.MovieServices;
import co.com.poli.cinema.utils.ErrorMessage;
import co.com.poli.cinema.utils.Response;
import co.com.poli.cinema.utils.ResponseBuilder;
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
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieServices movieServices;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        movieServices.save(movie);
        return builder.success(movie);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable("id") Long id) {
        Movie movie = movieServices.findById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();

        }
        movieServices.delete(movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movie = movieServices.findAll();
        if(movie.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/{id}")
    public Response findById(@Valid @PathVariable("id") Long id, BindingResult result){
        Movie movie = movieServices.findById(id);
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        return builder.success(movie);
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
