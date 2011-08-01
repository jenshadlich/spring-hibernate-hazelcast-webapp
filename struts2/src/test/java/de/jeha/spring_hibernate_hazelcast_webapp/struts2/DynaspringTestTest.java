package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(DynaspringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-dynaspring.xml" })
public class DynaspringTestTest {

	@PersistenceContext
	private EntityManager em;
	
	@Resource(name = "testBean")
	private SelfInjectingBean testBean;
	
	@Autowired
	private DataSource dataSource;

	@Test
	@Transactional
	public void test() {
		Assert.assertNotNull(dataSource);
		Assert.assertNotNull(testBean);
		Assert.assertNotNull(em);
	}

}
