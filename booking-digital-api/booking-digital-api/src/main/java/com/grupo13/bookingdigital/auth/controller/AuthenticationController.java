package com.grupo13.bookingdigital.auth.controller;

import com.grupo13.bookingdigital.auth.dto.AuthenticationRequest;
import com.grupo13.bookingdigital.auth.dto.AuthenticationResponse;
import com.grupo13.bookingdigital.auth.dto.LikeDto;
import com.grupo13.bookingdigital.auth.dto.RegisterRequest;
import com.grupo13.bookingdigital.auth.dto.UserDto;
import com.grupo13.bookingdigital.auth.dto.usernameDto;
import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.auth.service.impl.AuthenticationService;
import com.grupo13.bookingdigital.auth.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private final UserServiceImpl userService;

  @PostMapping("/register")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(authenticationService.register(request));
  }

  @PostMapping("/authenticate")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<AuthenticationResponse> login(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authentication(request));
  }

  @PostMapping("/setAdmin")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<String> setAdminRole(
      @RequestBody usernameDto userEmail
  )  {
    authenticationService.setAdmin(userEmail.getUsername());
    return ResponseEntity.ok().build();
  }

  @PostMapping("/user")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<UserDto> getUserByEmail(
      @RequestBody usernameDto userEmail
  ) {
    return ResponseEntity.ok(userService.getUserByEmail(userEmail.getUsername()));
  }

  @PostMapping("/userLikes")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<HttpStatus> toggleProductLike(@RequestBody LikeDto likeDto){
    return ResponseEntity.ok(userService.likeProduct(likeDto));
  }


}
