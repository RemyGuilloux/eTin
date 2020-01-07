package dev.louiiuol.etin.controllers.utils.validators.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.services.user.UserService;


/** <p> Validator for {@code UniqueUsername} constraint. </p> */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService service;

    /** <p> Creates a {@code UniqueUsernameValidator} with given injected {@code UserService}. </p>
     * @param*/
    protected UniqueUsernameValidator(UserService service) { this.service = service; }

    /** <p> Checks the unicity of the username based on the service returns </p>
     * @param
     * @return boolean */
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (null == username || username.isEmpty())
            return true;
        boolean valid = true;
        if (service.existsByUserName(username))
            valid = false;
        return valid;
    }

}
