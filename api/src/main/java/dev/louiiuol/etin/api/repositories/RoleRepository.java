package dev.louiiuol.etin.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.louiiuol.etin.domain.model.Role;
import dev.louiiuol.etin.domain.model.Role.RoleName;

/**
 * {@code JpaRepository} to handle {@code Role} persistence.
 * 
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Return {@code Role } if the RoleName matches
     * 
     * @param roleName to test if {@code Role} exist
     * @return {@code Optional<Role>} if the role exist
     */
    Optional<Role> findByName(RoleName roleName);
}