package com.lytuan99.projectIwarehouse.validation.anotation;


import com.lytuan99.projectIwarehouse.validation.validator.TaxValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = TaxValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tax {
    String message() default "Mã số thuế không hơp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
