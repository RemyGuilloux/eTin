package dev.louiiuol.etin.api.services;

import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.domain.model.dtos.request.UserLoginDto;
import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;
import dev.louiiuol.etin.domain.model.dtos.response.JwtResponse;
import dev.louiiuol.etin.domain.model.dtos.response.ResponseMessage;

/**
 * Service to handle {@code User} persistence.
 * 
 */
public interface UserService  {

    /**
     * Allow user to Log In through a {@code UserLoginDto}.
     *
     * @param credentials with {@code UserLoginDto} to persist.
     * @return a JwtResponse encapsulated in a {@code ResponseEntity<>}.
     */
    public ResponseEntity<JwtResponse> login(UserLoginDto input);

    /**
     * Allow user to register through a {@code UserRegisterDto}.
     *
     * @param credentials with {@code UserRegisterDto} to persist.
     * @return a ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    public ResponseEntity<ResponseMessage> register(UserRegisterDto input);
}