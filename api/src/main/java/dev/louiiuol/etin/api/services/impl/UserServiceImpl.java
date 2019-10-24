package dev.louiiuol.etin.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.api.repositories.UserRepository;
import dev.louiiuol.etin.api.services.UserService;
import dev.louiiuol.etin.domain.model.User;
import dev.louiiuol.etin.domain.model.dtos.request.UserLoginDto;
import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;
import dev.louiiuol.etin.domain.model.dtos.response.JwtResponse;
import dev.louiiuol.etin.domain.model.dtos.response.ResponseMessage;

/**
 * Default concrete implementation of {@code UserService}.
 * 
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

    @Autowired
	UserRepository userRepository;
    
    @Autowired
    ModelMapper mapper;

	/**
     * Try to authenticate with {@code UserLoginDto} given. 
     *
     * @param credentials with {@code UserLoginDto}
     * @return a JwtResponse encapsulated in a {@code ResponseEntity<>}.
     */
    @Override
    public ResponseEntity<JwtResponse> login(UserLoginDto input) {
       // TO DO Reimplement login authentification
        return null;
    }

	/**
	 * Check params to see if: 
	 * <ul>
	 * <li>the username / email doesn't already exist </li>
	 * <li>the role given exist </li>
     * Then the method persists a {@code UserCreateDto}.
     *
     * @param credentials with {@code UserCreateDto} to persist.
     * @return ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    @Override
    public ResponseEntity<ResponseMessage> register(UserRegisterDto input) {

		input.setPassword(encodePassword(input.getPassword()));
		
        User user = mapper.map(input, User.class);
		
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.CREATED);
    }

	/**
     * Utilitary method to encode some password
     *
     * @param input with {@code UserLoginDto} to persist.
     * @return a JwtResponse encapsulated in a {@code ResponseEntity<>}.
     */
	private String encodePassword(String input) {
        String password = input;
		return encoder.encode(password);
    }

    public Boolean existsByEmail(String email) {
        return  userRepository.existsByEmail(email);
    }

    public Boolean existsByUserName(String username) {
        return  userRepository.existsByUserName(username);
    }
    
}