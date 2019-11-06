package dev.louiiuol.etin.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.api.services.UserService;
import dev.louiiuol.etin.domain.models.dtos.requests.UserLoginDto;
import dev.louiiuol.etin.domain.models.dtos.requests.UserRegisterDto;
import dev.louiiuol.etin.domain.models.dtos.responses.JwtResponse;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

/**
 * a {@code RestController} to handle {@code Authentication}.
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserService service;

	/**
     * Allow user to Log In through a {@code UserLoginDto}.
     *
     * @param credentials with {@code UserLoginDto} to persist.
     * @return a JwtResponse encapsulated in a {@code ResponseEntity<>}.
     */
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> logIn(@Valid @RequestBody UserLoginDto input, Authentication auth) {
		return service.login(input);
	}

	/**
     * Persists a {@code UserCreateDto}.
     *
     * @param credentials with {@code UserCreateDto} to persist.
     * @return ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody UserRegisterDto input) {
		return service.register(input);
	}
}