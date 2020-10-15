package com.lytuan99.projectIwarehouse.validation.validator;


import com.lytuan99.projectIwarehouse.validation.anotation.Tax;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaxValidator implements ConstraintValidator<Tax, String> {
    @Override
    public boolean isValid(String tax, ConstraintValidatorContext arg1) {
        try{
            String[] subtax = tax.strip( ).split("-");
            String[] subsubtax = subtax[0].strip().split(" ");
            String part1 = subsubtax[0].strip(); // vch.. nãy vẫn hiện mà nhỉ
            String part2 = subsubtax[1].strip();
            String part3 = subtax[1].strip();

            return (!(part1 + part2 + part3).matches("\\D") && 
            part1.length() == 2 &&
            part2.length() == 7 &&
            part3.length() == 3);
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}