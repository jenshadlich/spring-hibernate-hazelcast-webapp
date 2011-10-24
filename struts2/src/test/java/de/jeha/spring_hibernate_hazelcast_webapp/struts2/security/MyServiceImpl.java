package de.jeha.spring_hibernate_hazelcast_webapp.struts2.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceImpl implements MyService {

	// @Secured("ROLE_USER")
	@PreAuthorize("hasRole('ROLE_USER')")
	public void foobar() {
		System.out.println("foobar");
	}
}
