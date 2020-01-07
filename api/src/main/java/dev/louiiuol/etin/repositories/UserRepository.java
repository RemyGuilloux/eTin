package dev.louiiuol.etin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.etin.models.CustomUser;

/** <p> {@code JpaRepository} to handle {@code CustomUser} persistence. </p> */
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    /** <p> Find {@code CustomUser} entity by their username. </p> 
     * @param
     * @return CustomUser if the username matches. */
    Optional<CustomUser> findByUsername(String username);

    /** <p> Find {@code CustomUser} entity by their id. </p> 
     * @param
     * @return CustomUser if the id matches. */
    Optional<CustomUser> findById(Long id);

    /** <p> Return either the {@code Customusername} exists or not. </p>
     * @param Customusername the tested {@code Customusername}
     * @return {@code true} if {@code Customusername} exists; {@code false} otherwise. */
    boolean existsByUsername(String username);

    /** Return either the {@code email} exists or not.
     * @param email the tested {@code email}
     * @return {@code true} if {@code email} exists; {@code false} otherwise. */
    boolean existsByEmail(String email);

    /** <p> Return a  list of all Customusers registered </p>
     * @return List<CustomUser> */
    List<CustomUser> findAll();

}