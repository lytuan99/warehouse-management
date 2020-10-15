package com.lytuan99.projectIwarehouse.validation.validator;


import com.lytuan99.projectIwarehouse.validation.anotation.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {
    @Override
    public boolean isValid(String status, ConstraintValidatorContext arg1) {
        try {
            return status.equals("true") || status.equals("false");
        } catch (Exception e) {
            return false;
        }
    }
}