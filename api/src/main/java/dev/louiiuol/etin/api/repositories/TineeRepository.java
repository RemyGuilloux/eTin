package dev.louiiuol.etin.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.louiiuol.etin.domain.models.Tinee;

/**
 * {@code JpaRepository} to handle {@code Tinee} persistence.
 * 
 */
@Repository
public interface TineeRepository extends JpaRepository<Tinee, Long> {
    
}