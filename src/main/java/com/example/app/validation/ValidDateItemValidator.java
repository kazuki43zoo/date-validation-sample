package com.example.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateItemValidator implements ConstraintValidator<ValidDateItem, DateItem> {

    @Override
    public void initialize(ValidDateItem constraintAnnotation) {
    }

    @Override
    public boolean isValid(DateItem value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.isValidDate();
    }

}
