package com.grupo13.bookingdigital.auth.service.impl;

import com.grupo13.bookingdigital.auth.dto.AuthenticationRequest;
import com.grupo13.bookingdigital.auth.dto.AuthenticationResponse;
import com.grupo13.bookingdigital.auth.dto.RegisterRequest;
import com.grupo13.bookingdigital.auth.dto.UserDto;
import com.grupo13.bookingdigital.auth.mapper.UserMap;
import com.grupo13.bookingdigital.auth.model.Role;
import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.exception.RepeatedUsername;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserMap userMap;

  public AuthenticationResponse register(RegisterRequest request) throws RepeatedUsername {
    if (userRepository.findByEmail(request.getEmail()).isPresent()){
      throw new RepeatedUsername("username repetido");
    }
    var user = UserEntity.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .city(request.getCity())
        .role(Role.USER)
        .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authentication(AuthenticationRequest request) {
  authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
          request.getEmail(),
          request.getPassword()
      )
  );
  var user = userRepository.findByEmail(request.getEmail())
      .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public void setAdmin(String userEmail) {
    UserEntity user = userRepository.findByEmail(userEmail).orElseThrow();
    user.setRole(Role.ADMIN);
    userRepository.save(user);
  }

}
