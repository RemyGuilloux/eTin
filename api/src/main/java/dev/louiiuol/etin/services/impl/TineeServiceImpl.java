package dev.louiiuol.etin.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.domain.model.Tinee;
import dev.louiiuol.etin.domain.model.dtos.request.TineeCreateDto;
import dev.louiiuol.etin.domain.model.dtos.response.ResponseMessage;
import dev.louiiuol.etin.domain.repository.TineeRepository;
import dev.louiiuol.etin.services.TineeService;

@Service
public class TineeServiceImpl implements TineeService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    TineeRepository repo;

    @Override
    public ResponseEntity<?> createTinee(TineeCreateDto input) {
        Tinee tinee = mapper.map(input, Tinee.class);
        repo.save(tinee);
        return new ResponseEntity<>(new ResponseMessage("Tinee " + tinee.getTitle()+" was successfully created!"), HttpStatus.CREATED);
    }

}