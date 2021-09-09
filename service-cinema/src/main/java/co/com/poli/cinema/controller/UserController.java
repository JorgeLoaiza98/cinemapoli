package co.com.poli.cinema.controller;


import co.com.poli.cinema.entities.User;
import co.com.poli.cinema.services.UserServices;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserServices userServices;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        userServices.save(user);
        return builder.success(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        User user = userServices.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();

        }
        userServices.delete(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> user = userServices.findAll();
        if(user.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User user = userServices.findById(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
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