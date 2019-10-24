package dev.louiiuol.etin.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.api.repositories.TineeRepository;
import dev.louiiuol.etin.api.services.TineeService;
import dev.louiiuol.etin.domain.models.Tinee;
import dev.louiiuol.etin.domain.models.dtos.requests.TineeCreateDto;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

/**
 * Default concrete implementation of {@code TineeService}.
 */
@Service
public class TineeServiceImpl implements TineeService {

    /**
     * Inject {@code ModelMapper} to map DTO into Entity and vice versa
     */
    @Autowired
    ModelMapper mapper;

    /**
     * Inject {@code TineeRepository} to implement queries on databse
     */
    @Autowired
    TineeRepository repo;

     /**
     * This method create a new Tinee based on {@code TineeCreateDto}.
     * @param input with {@code TineeCreateDto} to persist.
     * @return a ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    @Override
    public ResponseEntity<ResponseMessage> createTinee(TineeCreateDto input) {
        Tinee tinee = mapper.map(input, Tinee.class);
        repo.save(tinee);
        return new ResponseEntity<>(new ResponseMessage("Tinee was successfully created!"), HttpStatus.CREATED);
    }
}