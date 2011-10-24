package de.jeha.spring_hibernate_hazelcast_webapp.struts2.security;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test-security.xml" })
public class PrePostTest {

	@Autowired
	private MyService myService;

	@BeforeClass
	public static void setUp() {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("login", "pw"));
	}

	@Test
	public void test() {
		System.out.println(myService);
		myService.foobar();
	}

}
