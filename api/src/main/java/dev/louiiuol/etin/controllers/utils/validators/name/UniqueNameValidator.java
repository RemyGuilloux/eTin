package dev.louiiuol.etin.controllers.utils.validators.name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.louiiuol.etin.services.association.AssociationService;

/** <p> Validator for {@code UniqueName} constraint. </p> */
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    /** <p> Inject Association Service to handle verification </p> */
    private final AssociationService service;

    /** <p> Creates a {@code UniquenameValidator} with given injected {@code UserService}. </p>
     * @param*/
    protected UniqueNameValidator(AssociationService service) { this.service = service; }

    /** <p> Checks the unicity of the name based on the service returns </p>
     * @param
     * @return boolean */
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (null == name || name.isEmpty())
            return true;
        boolean valid = true;
        if (service.existsByName(name))
            valid = false;
        return valid;
    }

}
