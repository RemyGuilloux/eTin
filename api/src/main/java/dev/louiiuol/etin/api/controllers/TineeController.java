package dev.louiiuol.etin.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.etin.api.services.TineeService;
import dev.louiiuol.etin.domain.models.dtos.requests.TineeCreateDto;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

/**
 * a {@code RestController} to handle {@code Tinee}.
 */
@RestController
@RequestMapping("/tinee")
public class TineeController {

    @Autowired
    TineeService service;

    /**
     * If they are authorized, this method allow user to create a new Tinee through a {@code TineeCreateDto}.
     *
     * @param role from {@UserPrinciple}
     * @param form with {@code TineeCreateDto} to persist.
     * @return a ResponseMessage encapsulated in a {@code ResponseEntity<>}.
     */
    @PostMapping()
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ResponseMessage> createTinee(@Valid @RequestBody TineeCreateDto input){
        return service.createTinee(input);
    }

}