package de.jeha.spring_hibernate_hazelcast_webapp.struts2.beanFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-myBeanFactory.xml" })
public class MyBeanFactoryTest {

	@Autowired
	private MyBeanFactory myBeanFactory;

	@Test
	public void foobar() {
		MyBean bean1 = myBeanFactory.create(1);
		MyBean bean2 = myBeanFactory.create(2);
		
		Assert.assertTrue(bean1 instanceof MyBeanA);
		Assert.assertTrue(bean2 instanceof MyBeanB);

		bean1.fun();
		bean2.fun();
	}

}
