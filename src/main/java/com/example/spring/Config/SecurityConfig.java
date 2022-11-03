package com.example.spring.Config;

import com.example.spring.Security.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private StudentDetails studentDetails;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().antMatchers("/api/student").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.studentDetails).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
