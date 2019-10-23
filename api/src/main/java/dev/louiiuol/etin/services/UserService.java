package dev.louiiuol.etin.services;

import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.domain.model.dtos.request.UserLoginDto;
import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;

public interface UserService  {
    public ResponseEntity<?> login(UserLoginDto input);
    public ResponseEntity<?> register(UserRegisterDto input);
}