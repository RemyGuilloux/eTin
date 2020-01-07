package dev.louiiuol.etin.controllers.utils.validators.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.services.user.UserService;

/** <p> Validator for {@code UniqueEmail} constraint. </p> */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    /** <p> Inject User Service to handle verification </p> */
    private final UserService service;

    /** <p> Creates a {@code UniqueEmailValidator} with given injected {@code MemberService}. </p>
     * @param*/
    protected UniqueEmailValidator(UserService service) { this.service = service; }

    /** <p> Checks the unicity of the email based on the service returns </p>
     * @param 
     * @return boolean */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (null == email || email.isEmpty())
            return true;
        boolean valid = true;
        if (service.existsByEmail(email))
            valid = false;
        return valid;
    }

}
