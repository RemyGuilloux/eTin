package dev.louiiuol.etin.domain.models.dtos.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dev.louiiuol.etin.UnitTestConfig;

public class UserRegisterDtoTest extends UnitTestConfig {


    protected UserRegisterDtoTest() throws IOException {
        // Empty constructor
    }

        private static final String USER_DATA_JSON = "{\"userName\":\"louiiuol\",  \"email\":\"email@example.com\",  \"password\":\"123lol\"}";
	    private final UserRegisterDto actualEntity = MAPPER.readValue(USER_DATA_JSON, UserRegisterDto.class);


        @Test
        void shouldConstruct() {
            UserRegisterDto  actual = new UserRegisterDto();
            assertNotNull(actual);
        }

        @Test 
        void shouldReturnToString(){
            String password = "123lol";
            String expected = "{userName=louiiuol,email=email@example.com, password="+password+"}";
            String  actual = actualEntity.toString();
            assertEquals(expected, actual);
        }
}