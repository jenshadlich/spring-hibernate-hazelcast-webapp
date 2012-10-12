package de.jeha.spring_hibernate_hazelcast_webapp.struts2.copyAspect;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-copyAspect.xml" })
public class CopyAspectTest {

	@Autowired
	private MyService myService;

	@Test
	public void foobar() {
	    Bean s1 = myService.getBeanCopy();
	    Bean s2 = myService.getBean();
	    
	    Assert.assertNotSame(s1, s2);
	    Assert.assertEquals(s1.toString(), s2.toString());
	}

}
