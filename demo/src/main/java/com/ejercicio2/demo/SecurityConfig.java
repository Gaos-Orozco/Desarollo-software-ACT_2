package com.ejercicio2.demo;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("admin123")
        .roles("ADMIN")
        .build();

        UserDetails customerDetails = User.withDefaultPasswordEncoder()
        .username("cliente")
        .password("cliente123")
        .roles("CLIENTE")
        .build();

        return new InMemoryUserDetailsManager(user,customerDetails);
    }


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
        .csrf().disable()
        .authorizeHttpRequests(auth->auth
        .requestMatchers("/public/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/cliente/**").hasRole("CLIENTE")
         .anyRequest().authenticated()
        )
        .formLogin()
        .and()
        .httpBasic();
        return http.build();
    }
}
