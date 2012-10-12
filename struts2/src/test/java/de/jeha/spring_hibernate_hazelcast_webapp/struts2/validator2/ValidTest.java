package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator2;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test() {
        Set<ConstraintViolation<A>> constraintViolations = validator.validate(new A());
        // System.out.println(constraintViolations);
        for (ConstraintViolation<A> c : constraintViolations) {
            System.out.println(c.getMessage());
        }
    }
}