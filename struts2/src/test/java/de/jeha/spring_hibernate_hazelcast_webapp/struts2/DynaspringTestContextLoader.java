package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextLoader;

import dynaspring.Configuration;
import dynaspring.LispBeanDefinitionReader;
import dynaspring.LispBeanFactory;

/**
 * TODO: make this thing work
 * 
 * @author jeha
 *
 */
public class DynaspringTestContextLoader extends DefaultResourceLoader
		implements ContextLoader {

	private Configuration configuration = new Configuration();

	public DynaspringTestContextLoader() {
	}

	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		final DefaultListableBeanFactory factory = new LispBeanFactory();
		final PropertyPlaceholderConfigurer c = new PropertyPlaceholderConfigurer();
		c.setProperties(configuration);
		c.setIgnoreUnresolvablePlaceholders(true);

		GenericApplicationContext ctx = new GenericApplicationContext(factory) {
			{
				addBeanFactoryPostProcessor(c);
			}
		};
		
		for (String location : locations) {
			loadBeanDefinitions(getResource(location), factory);
			configuration.pushConfiguration(location, ctx);
		}

		return ctx;
	}

	@Override
	public String[] processLocations(Class<?> clazz, String... locations) {
		// TODO: really process ???
		return locations;
	}

	private void loadBeanDefinitions(Resource res,
			DefaultListableBeanFactory factory) throws IOException {
		LispBeanDefinitionReader reader = new LispBeanDefinitionReader(factory,
				configuration);
		// Configure the bean definition reader with this context's resource
		// loading environment.
		reader.setResourceLoader(this);
		reader.loadBeanDefinitions(res);
	}

}
