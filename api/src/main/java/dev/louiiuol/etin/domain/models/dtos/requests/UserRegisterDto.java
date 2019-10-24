package dev.louiiuol.etin.domain.models.dtos.requests;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.louiiuol.etin.api.controllers.validators.email.UniqueEmail;
import dev.louiiuol.etin.api.controllers.validators.username.UniqueUsername;

public class UserRegisterDto {

    @NotBlank
    @UniqueUsername
    @Size(min = 6, max = 50)
    private String userName;

    @NotBlank
    @Size(max = 60)
    @UniqueEmail
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    private final LocalDateTime subscriptionDate = LocalDateTime.now();

    protected UserRegisterDto() {}

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }
    
}