package dev.louiiuol.etin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.etin.models.Association;

/** <p> {@code JpaRepository} to handle {@code Association} persistence. </p> */
public interface  AssociationRepository extends JpaRepository<Association, Long> {

    /** <p> Find {@code Association} entity by their username. </p>
     * @param
     * @return Association if the name matches. */
    Optional<Association> findByName(String name);

    /** <p> Return either the {@code name} is unique or not. </p> 
     * @param
     * @return {@code true} if {@code name} exists; {@code false} otherwise. */
    boolean existsByName(String name);

    /** <p> Return a  list of all  Associations in database </p>
     * @return List<{@code Association}> */
    List<Association> findAll();

}