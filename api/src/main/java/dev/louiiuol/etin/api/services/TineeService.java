package dev.louiiuol.etin.api.services;

import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.domain.models.dtos.requests.TineeCreateDto;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;


/**
 * Service to handle {@code Tinee} persistence.
 * 
 */
public interface TineeService {

    /**
     * This method create a new Tinee based on {@code TineeCreateDto}.
     *
     * @param input with {@code TineeCreateDto} to persist.
     * @return a ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    public ResponseEntity<ResponseMessage> createTinee(TineeCreateDto tinee);
}
