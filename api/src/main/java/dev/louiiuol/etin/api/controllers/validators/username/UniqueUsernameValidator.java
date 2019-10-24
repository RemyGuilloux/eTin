package dev.louiiuol.etin.api.controllers.validators.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.api.services.UserService;

/**
 * Validator for {@code UniqueEmail} constraint.
 * 
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService service;

    /**
     * Creates a {@code UniqueEmailValidator} with given injected
     * {@code MemberService}.
     *
     * @param service an injected {@code MemberService}
     */
    protected UniqueUsernameValidator(UserService service) {
        this.service = service;
    }

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
