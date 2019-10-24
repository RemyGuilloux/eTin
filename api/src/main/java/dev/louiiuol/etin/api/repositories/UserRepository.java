package dev.louiiuol.etin.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.louiiuol.etin.domain.models.User;


/**
 * {@code JpaRepository} to handle {@code User} persistence.
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find {@code User} entity by their username.
     * 
     * @param username 
     * @return User if the username matches.
     */
    Optional<User> findByUserName(String userName);

    /**
     * Return either the {@code username} is unique or not.
     * 
     * @param username the tested {@code username}
     * @return {@code true} if {@code username} exists; {@code false} otherwise.
     */
    boolean existsByUserName(String userName);

    /**
     * Return either the {@code email} is unique or not.
     * 
     * @param email the tested {@code email}
     * @return {@code true} if {@code email} exists; {@code false} otherwise.
     */
    boolean existsByEmail(String email);
}