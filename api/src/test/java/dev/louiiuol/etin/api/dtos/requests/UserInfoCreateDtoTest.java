package dev.louiiuol.etin.api.dtos.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dev.louiiuol.etin.api.dtos.requests.users.UserInfoCreateDto;
import dev.louiiuol.etin.domain.UnitTestConfig;

public class UserInfoCreateDtoTest extends UnitTestConfig {


    protected UserInfoCreateDtoTest() throws IOException {
        // Empty constructor
    }

        private static final String USER_DATA_JSON = "{\"userName\":\"louiiuol\",  \"email\":\"email@example.com\",  \"password\":\"123lol\"}";
	    private final UserInfoCreateDto actualEntity = MAPPER.readValue(USER_DATA_JSON, UserInfoCreateDto.class);


        @Test
        void shouldConstruct() {
            //UserInfoCreateDto  actual = new UserInfoCreateDto();
            //assertNotNull(actual);
        }

        @Test 
        void shouldReturnToString(){
            String password = "123lol";
            String expected = "{userName=louiiuol,email=email@example.com, password="+password+"}";
            String  actual = actualEntity.toString();
            assertEquals(expected, actual);
        }
}