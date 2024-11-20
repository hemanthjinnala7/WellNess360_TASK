package com.example.spring_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_web.model.Users;

public interface UserRepo extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

}
