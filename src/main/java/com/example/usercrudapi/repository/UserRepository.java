package com.example.usercrudapi.repository;

import com.example.usercrudapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
