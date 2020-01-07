package dev.louiiuol.etin.controllers.dtos.requests.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.louiiuol.etin.controllers.utils.validators.email.UniqueEmail;
import dev.louiiuol.etin.controllers.utils.validators.username.UniqueUsername;

/** <p> A DTO representing the {@code UserUpdateDto} to update existing {@code User} </p> */
public class UserInfoUpdateDto {

    @NotBlank
    @UniqueUsername
    @Size(min = 6, max = 50)
    String username;

    @Size(max = 60)
    @UniqueEmail
    @Email
    String email;

    protected UserInfoUpdateDto() {
        //
    }
    /** <p> Return User username </p> */
    public String getUsername() { return username; }

    /** <p> Return User email </p> */
    public String getEmail() { return email; }

}