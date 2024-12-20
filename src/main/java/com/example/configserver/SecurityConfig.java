package com.example.configserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for non-browser clients
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Secure all endpoints
                )
                .httpBasic(httpBasic -> httpBasic.realmName("Config Server")); // Use HTTP Basic authentication with a realm name
        return http.build();
    }
}
