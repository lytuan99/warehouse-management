package com.lytuan99.projectIwarehouse.validation.validator;


import com.lytuan99.projectIwarehouse.validation.anotation.Price;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.compareTo("") == 0 || value == null)
            return true;
        try {
            float  val = Float.parseFloat(value);
        } catch (Exception e) {
            return false;
        }
        return true;

    }


}