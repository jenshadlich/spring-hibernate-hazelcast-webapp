package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-selfInjection.xml" })
public class SelfInjectionTest {

	@Resource(name = "testBean")
	private SelfInjectingBean testBean;

	@Test
	@Transactional
	public void foobar() {
		testBean.foo("call from outside");
	}

}

