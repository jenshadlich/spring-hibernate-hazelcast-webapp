package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CoBoundedStringConstraints implements ConstraintValidator<CoBoundedString, String> {

    private List<String> m_boundedTo;

    @Override
    public void initialize(CoBoundedString annotation) {
        m_boundedTo = Arrays.asList(annotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        if (!m_boundedTo.contains(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(value + " should be one of " + m_boundedTo)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}