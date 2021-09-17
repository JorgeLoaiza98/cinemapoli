package com.example.customer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer.entities.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
