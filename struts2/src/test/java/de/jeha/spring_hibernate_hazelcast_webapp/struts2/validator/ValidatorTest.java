package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidatorTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator
                .validate(new Foo(new String[] { "a", "c", "d" }));
        // System.out.println(constraintViolations);
        for (ConstraintViolation<Foo> c : constraintViolations) {
            System.out.println(c.getMessage());
        }
    }
}

class Foo {
    @CoBoundedString({ "a", "b" })
    private List<String> strings;

    public Foo(String[] strings) {
        this.strings = Arrays.asList(strings);
    }
}