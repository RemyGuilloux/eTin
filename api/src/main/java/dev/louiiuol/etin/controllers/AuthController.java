package dev.louiiuol.etin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.domain.model.dtos.request.UserLoginDto;
import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;
import dev.louiiuol.etin.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService service;

	@PostMapping("/login")
	public ResponseEntity<?> logIn(@Valid @RequestBody UserLoginDto input) {
		return service.login(input);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDto input) {
		return service.register(input);
	}
}