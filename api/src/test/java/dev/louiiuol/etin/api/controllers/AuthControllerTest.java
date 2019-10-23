package dev.louiiuol.etin.api.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.louiiuol.etin.domain.model.dtos.request.UserRegisterDto;

@Transactional
public class AuthControllerTest {

    @Autowired
    AuthController controller; 

    void should_Create_User(UserRegisterDto user){
        
    }
}