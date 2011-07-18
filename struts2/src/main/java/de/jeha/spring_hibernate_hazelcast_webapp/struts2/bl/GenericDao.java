package de.jeha.spring_hibernate_hazelcast_webapp.struts2.bl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("genericDao")
@Transactional
public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;

	public <T> void persist(T entity) {
		entityManager.persist(entity);
	}

	public <T> void delete(Class<T> entityType, Long id) {
		T entity = get(entityType, id);
		delete(entity);
	}

	public <T> void delete(T entity) {
		if (!entityManager.contains(entity)) {
			entity = entityManager.merge(entity);
		}
		entityManager.remove(entity);

	}

	public <T> T get(Class<T> entityType, Long id) {
		return entityManager.find(entityType, id);
	}

	public <T> T update(T entity) {
		return entityManager.merge(entity);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

	public <T> T findSingle(CriteriaQuery<T> criteriaQuery) {
		try {
			return entityManager.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
