package de.jeha.spring_hibernate_hazelcast_webapp.struts2.beanFactory;

import javax.annotation.Resource;

public class MyBeanB implements MyBean {

	@Resource
	private MyService myService;

	@Override
	public void fun() {
		myService.call();
	}

}
