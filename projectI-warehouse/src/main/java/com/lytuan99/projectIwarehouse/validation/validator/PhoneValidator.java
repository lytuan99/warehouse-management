package com.lytuan99.projectIwarehouse.validation.validator;


import com.lytuan99.projectIwarehouse.validation.anotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String phone, ConstraintValidatorContext arg1) {
        try {
            return (phone == null) || (phone.length() == 0) || (phone.length() >= 10 && phone.matches("^[\\d]*$"));
        } catch (Exception e) {
            return false;
        }
    }
}   