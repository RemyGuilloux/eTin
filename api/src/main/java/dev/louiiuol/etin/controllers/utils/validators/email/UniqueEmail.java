package dev.louiiuol.etin.controllers.utils.validators.email;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

/** <p> Interface to define configuration of {@code UniqueEmailValidator} </p */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

    String message() default "L'adresse email doit être unique !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
} 