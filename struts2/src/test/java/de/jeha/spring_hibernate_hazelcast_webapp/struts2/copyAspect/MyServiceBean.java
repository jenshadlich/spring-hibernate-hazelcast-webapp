package de.jeha.spring_hibernate_hazelcast_webapp.struts2.copyAspect;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceBean implements MyService {

    private final Bean bean = new Bean();
    
	@Override
	@CopyReturnValue
	public Bean getBeanCopy() {
	    return bean;
	}
	
	public Bean getBean() {
	    return bean;
	}
}
