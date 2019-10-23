package dev.louiiuol.etin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.domain.model.dtos.request.TineeCreateDto;
import dev.louiiuol.etin.services.TineeService;

@RestController
@RequestMapping("/tinee")
public class TineeController {

    @Autowired
    TineeService service;

    @PostMapping()
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createTinee(@Valid @RequestBody TineeCreateDto input){
        return service.createTinee(input);
    }

}