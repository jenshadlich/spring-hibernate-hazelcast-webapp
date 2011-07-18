package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.jeha.spring_hibernate_hazelcast_webapp.struts2.bl.GenericDao;
import de.jeha.spring_hibernate_hazelcast_webapp.struts2.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
public class HazelcastClusterTest {

	@Resource
	private GenericDao genericDao;

	@Test
	public void foobar() {

	}

	@Ignore
	@Test
	@Rollback(false)
	public void setupTestData() {
		User u = new User();
		u.setUsername("u" + System.currentTimeMillis());
		genericDao.persist(u);
	}
}
