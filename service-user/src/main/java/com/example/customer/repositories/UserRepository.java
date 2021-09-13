package com.example.customer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
