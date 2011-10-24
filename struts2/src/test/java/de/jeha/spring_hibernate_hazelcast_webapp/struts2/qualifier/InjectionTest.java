package de.jeha.spring_hibernate_hazelcast_webapp.struts2.qualifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-empty.xml" })
public class InjectionTest {

	@Autowired
	private MyController controller;

	@Test
	public void test() {
		System.out.println(controller);
	}

}
