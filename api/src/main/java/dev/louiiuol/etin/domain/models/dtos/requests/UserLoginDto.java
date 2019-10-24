package dev.louiiuol.etin.domain.models.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * A DTO representing the {@code UserLoginDto} to authenticate in the application
 */
public class UserLoginDto {
    
    /**
     * The username of the given entity.
     */
    @NotBlank
    @Size(min=3, max = 60)
    private String userName;

    /**
     * The password of the given entity.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * Default empty no-arg constructor
     */
    protected UserLoginDto() {}
    
}