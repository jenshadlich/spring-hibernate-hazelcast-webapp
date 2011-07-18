package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import java.util.Map;

import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;

import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;

@Ignore("wird gerade nicht gebraucht")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
public class SchemaValidationTest implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * Schemavalidierung.
	 */
	@Test
	public void validateSchema() {
		LocalContainerEntityManagerFactoryBean factory = applicationContext
				.getBean("&entityManagerFactory",
						LocalContainerEntityManagerFactoryBean.class);

		PersistenceUnitInfo pui = factory.getPersistenceUnitInfo();
		Map<String, Object> map = factory.getJpaPropertyMap();
		map.put("hibernate.hbm2ddl.auto", "validate");

		PersistenceProvider provider = getPersistenceProvider(factory, pui);

		try {
			provider.createContainerEntityManagerFactory(pui, map);
		} catch (PersistenceException e) {
			Throwable cause = e.getCause();
			if (cause != null && cause instanceof HibernateException) {
				Assert.fail(cause.getMessage());
			} else {
				throw e;
			}
		}
	}

	/**
	 * Gibt den PersistenceProvider zurück.
	 * 
	 * @param factory
	 *            LocalContainerEntityManagerFactoryBean
	 * @param pui
	 *            PersistenceUnitInfo
	 * @return PersistenceProvider
	 */
	private PersistenceProvider getPersistenceProvider(
			LocalContainerEntityManagerFactoryBean factory,
			PersistenceUnitInfo pui) {
		PersistenceProvider provider = factory.getPersistenceProvider();

		if (provider == null) {
			String providerClassName = pui.getPersistenceProviderClassName();
			if (providerClassName == null) {
				throw new IllegalArgumentException(
						"No PersistenceProvider specified in EntityManagerFactory configuration, "
								+ "and chosen PersistenceUnitInfo does not specify a provider class name either");
			}
			Class<?> providerClass = ClassUtils.resolveClassName(
					providerClassName, applicationContext.getClassLoader());
			provider = (PersistenceProvider) BeanUtils
					.instantiateClass(providerClass);
		}
		return provider;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
