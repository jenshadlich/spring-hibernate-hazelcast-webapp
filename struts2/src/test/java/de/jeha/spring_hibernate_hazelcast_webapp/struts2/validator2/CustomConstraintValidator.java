package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomConstraintValidator implements ConstraintValidator<CustomConstraint, B> {

    @Override
    public void initialize(CustomConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(B value, ConstraintValidatorContext context) {
        System.out.println("isValid");
        return true;
    }
}