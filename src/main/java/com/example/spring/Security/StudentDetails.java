package com.example.spring.Security;

import com.example.spring.Models.Students;
import com.example.spring.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class StudentDetails implements UserDetailsService{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Students students = this.studentRepo.findByEmail(username).orElseThrow();
        return students;
    }
}
