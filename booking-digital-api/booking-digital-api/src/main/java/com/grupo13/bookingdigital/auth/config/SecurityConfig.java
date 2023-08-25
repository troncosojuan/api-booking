package com.grupo13.bookingdigital.auth.config;

import com.grupo13.bookingdigital.auth.filter.JwtAuthFilter;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {


  private final JwtAuthFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .cors()
        .and()
        .authorizeHttpRequests()
        .requestMatchers("/auth/register").permitAll()
        .requestMatchers("/auth/authenticate").permitAll()
        .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/category").permitAll()
        .requestMatchers(HttpMethod.POST, "/category").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/category/**").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/product").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/product/**").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/auth/setAdmin").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/product/delete").hasAnyAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }



}
