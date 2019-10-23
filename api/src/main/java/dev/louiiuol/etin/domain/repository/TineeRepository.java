package dev.louiiuol.etin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.louiiuol.etin.domain.model.Tinee;

@Repository
public interface TineeRepository extends JpaRepository<Tinee, Long> {
    
}