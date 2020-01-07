package dev.louiiuol.etin.controllers.dtos.requests.users;

import java.util.Set;

import javax.persistence.Convert;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.louiiuol.etin.controllers.utils.validators.email.UniqueEmail;
import dev.louiiuol.etin.controllers.utils.validators.username.UniqueUsername;
import dev.louiiuol.etin.models.Role;
import dev.louiiuol.etin.services.utils.BooleanConverter;

/** <p> A DTO representing the {@code UserRegisterDto} to create new {@code User} </p> */
public class UserInfoCreateDto {

    @NotBlank
    @UniqueUsername
    @Size(min = 6, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @UniqueEmail
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private Set<Role> roles;

    @Convert(converter = BooleanConverter.class)
    private boolean enabled = true;

    @Convert(converter = BooleanConverter.class)
    private boolean accountNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    private boolean accountNonLocked = true;

    @Convert(converter = BooleanConverter.class)
    private boolean credentialsNonExpired = true;

    protected UserInfoCreateDto() { }

    /** <p> returns User username </p> */
    public String getUsername() { return this.username; }

     /** <p> returns User email </p> */
    public  String getEmail() { return this.email; }

    /** <p> returns User roles </p> */
    public  Set<Role> getRoles() { return this.roles; }

        /** <p> Returns User password (internal purpose only) </p> */
        public String getPassword() { return password; }

        /** <p> Set User password (internal purpose only) </p> */
        public void setPassword(String password) { this.password = password; }


}