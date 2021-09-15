package com.example.bookings.entities;


import com.example.bookings.model.Movie;
import com.example.bookings.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Bookings {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;
    @NotEmpty(message = "debe elegir un horario")
    @Column(name = "showtimes_id")
    private Long showtimes_id;
    @NotEmpty(message = "debe elegir un usuario para la reserv")
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "movies_id")
    private List<Long> movies_id;
    @Transient
    private Movie movie;
    @Transient
    private User user;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(id, bookings.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
