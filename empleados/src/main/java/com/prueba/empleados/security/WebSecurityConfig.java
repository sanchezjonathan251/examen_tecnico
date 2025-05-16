package com.prueba.empleados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.prueba.empleados.utils.Constants;

@EnableWebSecurity
@Configuration
class WebSecurityConfig{

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    	http
        .csrf((csrf) -> csrf
            .disable())
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(HttpMethod.POST, Constants.LOGIN_URL).permitAll()
            .requestMatchers("/security/**").permitAll()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-ui.html"
                ).permitAll()
            .anyRequest().authenticated()
        )
        .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
        .httpBasic().disable();

        return http.build();
    }
}