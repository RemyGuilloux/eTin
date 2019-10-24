package dev.louiiuol.etin.api.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class AuthControllerTest {

    @Autowired
    AuthController controller; 

    void should_Register_User(){
    }
}