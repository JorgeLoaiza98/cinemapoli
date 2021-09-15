package com.example.showtimes.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;
    @NotEmpty(message = "La fecha no debe estar vacio")
    @Column(name="date")
    private String date;
    @Column(name = "movies_id")
    private List<Long> movies_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTimes showTimes = (ShowTimes) o;
        return Objects.equals(id, showTimes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



