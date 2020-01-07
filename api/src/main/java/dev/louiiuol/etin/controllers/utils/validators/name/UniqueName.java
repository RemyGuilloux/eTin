package dev.louiiuol.etin.controllers.utils.validators.name;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

/** <p> Interface to define configuration of {@code UniqueNameValidator} </p */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Constraint(validatedBy = UniqueNameValidator.class)
public @interface UniqueName {

    String message() default "Le nom doit être unique !";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}