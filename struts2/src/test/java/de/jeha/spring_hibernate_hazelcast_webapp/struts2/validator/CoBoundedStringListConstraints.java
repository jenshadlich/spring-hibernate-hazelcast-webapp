package de.jeha.spring_hibernate_hazelcast_webapp.struts2.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CoBoundedStringListConstraints implements
		ConstraintValidator<CoBoundedString, List<String>> {

	private CoBoundedString m_annotation;

	@Override
	public void initialize(CoBoundedString annotation) {
		m_annotation = annotation;
	}

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean allValid = true;
        CoBoundedStringConstraints constraints = new CoBoundedStringConstraints();
        constraints.initialize(m_annotation);
        for (String string : value) {
            System.out.println(string);
            if (!constraints.isValid(string, context)) {
                allValid = false;
            }
        }
        return allValid;
    }

}