package dev.louiiuol.codOctopus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.louiiuol.codOctopus.model.Role;
import dev.louiiuol.codOctopus.model.RoleName;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}