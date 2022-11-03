package com.example.spring.Repository;

import com.example.spring.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface StudentRepo extends JpaRepository<Students, Integer> {
    Optional<Students> findByEmail(String email);
}