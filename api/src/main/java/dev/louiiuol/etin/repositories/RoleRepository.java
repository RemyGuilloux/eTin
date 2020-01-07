package dev.louiiuol.etin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.etin.models.Role;

/** <p> {@code JpaRepository} to handle {@code Role} persistence. </p> */
public interface RoleRepository  extends  JpaRepository<Role, Long> {

	Role findByCode(String string);

}