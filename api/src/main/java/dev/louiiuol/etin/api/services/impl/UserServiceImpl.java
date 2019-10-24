package dev.louiiuol.etin.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.api.repositories.UserRepository;
import dev.louiiuol.etin.api.services.UserService;
import dev.louiiuol.etin.domain.models.User;
import dev.louiiuol.etin.domain.models.dtos.requests.UserLoginDto;
import dev.louiiuol.etin.domain.models.dtos.requests.UserRegisterDto;
import dev.louiiuol.etin.domain.models.dtos.responses.JwtResponse;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

/**
 * Default concrete implementation of {@code UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Inject {@code PasswordEncode} to encode User password
     */
	@Autowired
	PasswordEncoder encoder;

    /**
     * Inject {@code UserRepository} to implement queries to database
     */
    @Autowired
	UserRepository userRepository;
    
    /**
     * Inject {@code ModalMapper} to map DTO into Entity and vice versa
     */
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
       // TO DO Reimplement login authentification based on NEW JWT Impl
        return null;
    }

	/**
     * Try to register new user based on {@code UserCreateDto}
	 * <li>Encode the given password
     * <li>Map DTO into Entity {@code User}
     * <li> Save in Repository
     * Then the method persists a {@code UserCreateDto}.
     *
     * @param credentials with {@code UserCreateDto} to persist.
     * @return ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    @Override
    public ResponseEntity<ResponseMessage> register(UserRegisterDto input) {
        String passwordEncoded = encoder.encode(input.getPassword());
        input.setPassword(passwordEncoded);
        User user = mapper.map(input, User.class);
		userRepository.save(user);
        return new ResponseEntity<>(new ResponseMessage("Congratulation " + input.getUserName() + ", you successfully registered !"), HttpStatus.CREATED);
    }

    /**
     * Return either the {@code email} is unique or not.
     * 
     * @param email the tested {@code email}
     * @return {@code true} if {@code email} exists; {@code false} otherwise.
     */
    public boolean existsByEmail(String email) {
        return  userRepository.existsByEmail(email);
    }

    /**
     * Return either the {@code username} is unique or not.
     * 
     * @param username the tested {@code username}
     * @return {@code true} if {@code username} exists; {@code false} otherwise.
     */
    public boolean existsByUserName(String username) {
        return  userRepository.existsByUserName(username);
    }
    
}