package dev.louiiuol.etin.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.louiiuol.etin.api.IntegrationTestConfig;
import dev.louiiuol.etin.domain.models.dtos.requests.UserRegisterDto;
import dev.louiiuol.etin.domain.models.dtos.responses.ResponseMessage;

@Transactional
public class UserControllerTest extends IntegrationTestConfig {

    @Autowired
    UserController controller; 

    @BeforeEach
	void addEntity() {
		String existing = "{\"userName\":\"test\", \"password\":\"test\", \"email\":\"test@test.fr\"}";
		UserRegisterDto existingEntity = jsonConvert(existing, UserRegisterDto.class);
		controller.registerUser(existingEntity);
	}

    @Test 
    void shouldFindUser() {
        
    }
    @Test
    void shouldRegisterSuccessfully(){
        String password = "password";
        String dto = "{\"userName\":\"admin\", \"email\":\"admin@test.fr\", \""+password+"\":\"password\"}";
		UserRegisterDto dtoEntity = jsonConvert(dto, UserRegisterDto.class);
        ResponseEntity<ResponseMessage> expected = new ResponseEntity<>(new ResponseMessage("Congratulation louiiuol, you successfully registered !"), HttpStatus.CREATED);
        ResponseEntity<ResponseMessage> actual =  controller.registerUser(dtoEntity);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFailRegirstrationWithExistingEmail(){
        String password = "password";
        String dto = "{\"userName\":\"admin\", \""+password+"\":\"password\", \"email\":\"admin@test.fr\"}";
		UserRegisterDto dtoEntity = jsonConvert(dto, UserRegisterDto.class);
        ResponseEntity<ResponseMessage> expected = new ResponseEntity<>(new ResponseMessage("Congratulation louiiuol, you successfully registered !"), HttpStatus.CREATED);
        ResponseEntity<ResponseMessage> actual =  controller.registerUser(dtoEntity);
        assertEquals(expected, actual);
    }

}