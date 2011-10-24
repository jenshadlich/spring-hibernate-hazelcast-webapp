package de.jeha.spring_hibernate_hazelcast_webapp.struts2.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("controller")
public class MyController {

	@Autowired
	public MyController(@Qualifier("child2service") ParentService child1service) {
		System.out.println(child1service);
	}
}