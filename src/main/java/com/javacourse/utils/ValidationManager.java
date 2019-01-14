package com.javacourse.utils;

import com.javacourse.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationManager {
    private static Validator getValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return  factory.getValidator();
    }

    public static  <T>  boolean isValidate(T object){
        Validator validator = getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        return constraintViolations.isEmpty();
    }

    public static   <T>  String getFirsErrorMessage(T object){
        Validator validator = getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        return constraintViolations.iterator().next().getMessage();
    }

}
