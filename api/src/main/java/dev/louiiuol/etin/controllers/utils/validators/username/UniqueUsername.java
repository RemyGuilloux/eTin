package dev.louiiuol.etin.controllers.utils.validators.username;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

/** <p> Interface to define configuration of {@code UniqueUserNameValidator} </p */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {

    String message() default "Le nom d'utilisateur doit être unique !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}