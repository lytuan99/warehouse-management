package com.lytuan99.projectIwarehouse.validation.anotation;


import com.lytuan99.projectIwarehouse.validation.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {
    String message() default "Định dạng số điện thoại khồng hợ lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}