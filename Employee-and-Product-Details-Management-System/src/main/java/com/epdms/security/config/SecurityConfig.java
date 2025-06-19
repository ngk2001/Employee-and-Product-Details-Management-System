package com.epdms.security.config;


import com.epdms.service.EmployeeUserDetailsService;

import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return  http
              .csrf(csrf -> csrf.disable())
              .authorizeHttpRequests(auth -> auth
              .requestMatchers("/epdms/manager/**").hasRole("MANAGER")
              .requestMatchers("/epdms/product/**").hasAnyRole("MANAGER","EMPLOYEE")
              .anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults())
              .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .build();
      }
   

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
