package co.com.poli.cinema.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;
    @NotEmpty(message = "El titulo no debe ser vacio")
    @Column(name="title",nullable = false)
    private String title;
    @NotEmpty(message = "El director no debe ser vacio")
    @Column(name="director",nullable = false)
    private String director;
    @Min(value = 1, message = "El valor del rating no puede ser menor a 1")
    @Max(value = 5, message = "El valor del rating no puede ser mayor a 5")
    @Column(name="rating")
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}



