package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "testBean")
public class SelfInjectingBean {

	@Resource
	private SelfInjectingBean testBean = null;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void foo(String string) {
		System.out.println(string);
		testBean.bar("call from self");
	}

	public void bar(String string) {
		System.out.println(string);
	}
}