package com.javacourse.utils;

import com.javacourse.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationManager {
    private static Validator validator;
    public ValidationManager(HttpServletRequest request){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public  <T>  boolean isValidate(T object){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        return constraintViolations.isEmpty();
    }

    public  <T>  String getFirsErrorMessage(T object){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        return constraintViolations.iterator().next().getMessage();
    }

}
