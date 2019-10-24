package dev.louiiuol.etin.api.controllers.validators.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.api.services.UserService;

/**
 * Validator for {@code UniqueUsername} constraint.
 * 
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService service;

    /**
     * Creates a {@code UniqueUsernameValidator} with given injected
     * {@code UserService}.
     *
     * @param service an injected {@code UserService}
     */
    protected UniqueUsernameValidator(UserService service) {
        this.service = service;
    }

    /**
     * Checks the unicity of the username based on the service returns
     * @param username 
     * @return boolean
     */
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (null == username || username.isEmpty()) { // Ignored
            return true;
        }
        boolean valid = true;
        if (service.existsByUserName(username)) {
            valid = false;
        }
        return valid;
    }

}
