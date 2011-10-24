package de.jeha.spring_hibernate_hazelcast_webapp.struts2.beanFactory;

import java.util.Map;

public class MyBeanFactory {

	private Map<Integer, MyBean> beans;

	public MyBean create(Integer which) {
		if (which != null)
			return beans.get(which);
		else
			throw new IllegalArgumentException("Unknown bean");
	}

	public void setBeans(Map<Integer, MyBean> beans) {
		this.beans = beans;
	}
}
