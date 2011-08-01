package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class DynaspringJUnit4ClassRunner extends SpringJUnit4ClassRunner {

	public DynaspringJUnit4ClassRunner(Class<?> clazz)
			throws InitializationError {
		super(clazz);
	}

	@Override
	protected String getDefaultContextLoaderClassName(Class<?> clazz) {
		return DynaspringTestContextLoader.class.getCanonicalName();
	}
}
