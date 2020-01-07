package dev.louiiuol.etin.controllers.dtos.requests.users;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/** <p> A DTO representing the {@code UserLoginDto} to authenticate in the application */
public class UserAuthLoginDto {

    /**
     * <p>
     * The username of the given entity.
     */
    @NotBlank
    @Size(min = 3, max = 60)
    private String username;

    /**
     * <p>
     * The password of the given entity.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * <p>
     * Default empty no-arg constructor
     */
    protected UserAuthLoginDto() {
    }
    
}