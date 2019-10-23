package dev.louiiuol.etin.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.louiiuol.etin.api.repositories.UserRepository;
import dev.louiiuol.etin.domain.model.User;
import dev.louiiuol.etin.security.UserPrinciple;

/**
 * Default concrete implementation of {@code UserDetailsService}.
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	 /**
     * Find {@code User} with his {@code username}.
     *
     * @param username
	 * @throws UsernameNotFoundException
     * @return a ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username)
														.orElseThrow( () -> 
															new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		return UserPrinciple.build(user);
	}
}