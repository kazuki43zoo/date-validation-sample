package com.example.app.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidDateItemValidator implements ConstraintValidator<ValidDateItem, DateItem> {

    private boolean required;
    private int minYear;
    private int maxYear;

    @Override
    public void initialize(ValidDateItem constraint) {
        this.required = constraint.required();
        this.minYear = constraint.minYear();
        this.maxYear = constraint.maxYear();
    }

    @Override
    public boolean isValid(DateItem value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        if (value.getYear() == null && value.getMonth() == null && value.getDay() == null) {
            if (required) {
                Arrays.asList("year", "month", "day")
                        .forEach(name -> context.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                                .addPropertyNode(name)
                                .addConstraintViolation());
                context.disableDefaultConstraintViolation();
                return false;
            } else {
                return true;
            }
        }

        boolean isValid = isValidPropertyValue(value.getYear(), "year", minYear, maxYear, context)
                & isValidPropertyValue(value.getMonth(), "month", 1, 12, context)
                & isValidPropertyValue(value.getDay(), "day", 1, 31, context);

        if (isValid) {
            isValid = value.isValid();
        } else {
            context.disableDefaultConstraintViolation();
        }

        return isValid;
    }

    private boolean isValidPropertyValue(Integer value, String name, int min, int max, ConstraintValidatorContext context) {
        if (value == null) {
            context.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                    .addPropertyNode(name)
                    .addConstraintViolation();
            return false;
        }
        if (value < min) {
            context.buildConstraintViolationWithTemplate("{com.example.app.validation.ValidDateItem." + StringUtils.capitalize(name) + "Min.message}")
                    .addPropertyNode(name)
                    .addConstraintViolation();
            return false;
        }
        if (max < value) {
            context.buildConstraintViolationWithTemplate("{com.example.app.validation.ValidDateItem." + StringUtils.capitalize(name) + "Max.message}")
                    .addPropertyNode(name)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
