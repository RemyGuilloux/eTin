package dev.louiiuol.etin.services;

import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.domain.model.dtos.request.TineeCreateDto;

public interface TineeService {

    public ResponseEntity<?> createTinee(TineeCreateDto tinee);
}
