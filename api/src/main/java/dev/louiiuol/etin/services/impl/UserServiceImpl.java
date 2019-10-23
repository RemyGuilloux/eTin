package dev.louiiuol.etin.services.impl;

import java.util.HashSet;
import java.util.Set;

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

import dev.louiiuol.etin.domain.model.Role;
import dev.louiiuol.etin.domain.model.Role.RoleName;
import dev.louiiuol.etin.domain.model.User;
import dev.louiiuol.etin.domain.model.dtos.request.UserLoginDto;
import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;
import dev.louiiuol.etin.domain.model.dtos.response.JwtResponse;
import dev.louiiuol.etin.domain.model.dtos.response.ResponseMessage;
import dev.louiiuol.etin.domain.repository.RoleRepository;
import dev.louiiuol.etin.domain.repository.UserRepository;
import dev.louiiuol.etin.security.jwt.JwtProvider;
import dev.louiiuol.etin.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

	@Autowired
	PasswordEncoder encoder;

    @Autowired
	UserRepository userRepository;

	@Autowired
    RoleRepository roleRepository;
    
    @Autowired
    ModelMapper mapper;

    @Override
    public ResponseEntity<?> login(UserLoginDto input) {
        Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(input.getUserName(), input.getPassword()));
		System.out.println("passed");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @Override
    public ResponseEntity<?> register(UserRegisterDto input) {

        if (userRepository.existsByUserName(input.getUserName())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(input.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		encodePassword(input);
		
        User user = mapper.map(input, User.class);
		
		Set<String> strRoles = input.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.CREATED);
    }

	private void encodePassword(UserRegisterDto input) {
        String password = input.getPassword();
		String encoded = encoder.encode(password);
		input.setPassword(encoded);
    }
    
}