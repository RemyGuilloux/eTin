package dev.louiiuol.etin.domain.models.dtos.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.louiiuol.etin.api.controllers.validators.email.UniqueEmail;
import dev.louiiuol.etin.api.controllers.validators.username.UniqueUsername;

/**
 * A DTO representing the {@code UserRegisterDto} to create new {@code User}
 */
public class UserRegisterDto {

    /**
     * The username of the given entity.
     */
    @NotBlank
    @UniqueUsername
    @Size(min = 6, max = 50)
    private String userName;

    /**
     * The email of the given entity.
     */
    @NotBlank
    @Size(max = 60)
    @UniqueEmail
    @Email
    private String email;
    
    /**
     * The password of the given entity.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * Default empty no-arg constructor
     */
    protected UserRegisterDto() {}

    /**
     * Overriding method to return JSON naturally
     */
    @Override
    public String toString() {
        return "{userName=" + userName + ",email=" + email + ", password=" + password +"}";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }
    
}