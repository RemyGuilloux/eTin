package dev.louiiuol.etin.api.controllers.validators.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.api.services.UserService;

/**
 * Validator for {@code UniqueEmail} constraint.
 * 
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService service;

    /**
     * Creates a {@code UniqueEmailValidator} with given injected
     * {@code MemberService}.
     *
     * @param service an injected {@code MemberService}
     */
    protected UniqueEmailValidator(UserService service) {
        this.service = service;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (null == email || email.isEmpty()) { // Ignored
            return true;
        }
        boolean valid = true;
        if (service.existsByEmail(email)) {
            valid = false;
        }
        return valid;
    }

}
