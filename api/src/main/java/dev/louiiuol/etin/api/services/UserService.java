package dev.louiiuol.etin.api.services;

import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.domain.models.dtos.requests.UserLoginDto;
import dev.louiiuol.etin.domain.models.dtos.requests.UserRegisterDto;
import dev.louiiuol.etin.domain.models.dtos.responses.JwtResponse;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

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


        /**
     * Return either the {@code email} is unique or not.
     * 
     * @param email the tested {@code email}
     * @return {@code true} if {@code email} exists; {@code false} otherwise.
     */
    public boolean existsByEmail(String email);

        /**
     * Return either the {@code username} is unique or not.
     * 
     * @param username the tested {@code username}
     * @return {@code true} if {@code username} exists; {@code false} otherwise.
     */
    public boolean existsByUserName(String username);
}