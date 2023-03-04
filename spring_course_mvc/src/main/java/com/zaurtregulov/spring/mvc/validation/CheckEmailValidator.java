package com.zaurtregulov.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator
        // CheckEmail это нами созданная аннотация, а String это тип данных к которому мы будем применять аннотацию
        implements ConstraintValidator<CheckEmail, String> {

    private String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
        endOfEmail = checkEmail.value(); // конечная часть email
    }

    @Override
    public boolean isValid(String enteredValue
            , ConstraintValidatorContext constraintValidatorContext) {

// логика в строке ниже - enteredValue т.е. введённая почта соответствует endOfEmail ?
        return enteredValue.endsWith(endOfEmail);
    }
}
