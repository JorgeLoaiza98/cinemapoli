package com.example.bookings.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class User {

    private Long id;
    private String name;
    private String lastname;

}
