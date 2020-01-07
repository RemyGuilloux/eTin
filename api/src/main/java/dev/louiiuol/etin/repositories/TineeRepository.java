package dev.louiiuol.etin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.etin.models.CustomUser;
import dev.louiiuol.etin.models.tinee.Tinee;

/** <p> {@code JpaRepository} to handle {@code Tinee} persistence. </p> */
public interface TineeRepository extends JpaRepository<Tinee, Long> {

    /** <p>  Find {@code Tinee} entity by their Id. </p>
     * @param 
     * @return CustomUser if the Id matches. */
    Optional<Tinee> findById(Long id);

    /** <p> Find {@code Tinee} entity by their title. </p>
     * @param
     * @return CustomUser if the title matches.*/
    Optional<Tinee> findByTitle(String title);

    /** <p> Find {@code Tinee} entity by their Author. </p>
     * @param
     * @return CustomUser if the title matches.*/
    Optional<Tinee> findByAuthor(CustomUser author);
}