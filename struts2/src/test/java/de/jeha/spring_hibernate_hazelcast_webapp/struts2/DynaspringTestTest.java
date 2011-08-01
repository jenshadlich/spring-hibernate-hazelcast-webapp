package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.jeha.spring_hibernate_hazelcast_webapp.struts2.entities.User;

@RunWith(DynaspringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-dynaspring.lisp" })
public class DynaspringTestTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	public void test() {
		em.persist(new User());
	}

}
