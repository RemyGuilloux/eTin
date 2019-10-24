package dev.louiiuol.etin.api.controllers.validators.username;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {

    String message() default "{E_UNIQUE_EMAIL}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}