package de.jeha.spring_hibernate_hazelcast_webapp.struts2.beanFactory;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceBean implements MyService {

	@Override
	public void call() {
		System.out.println("called");
	}
}
