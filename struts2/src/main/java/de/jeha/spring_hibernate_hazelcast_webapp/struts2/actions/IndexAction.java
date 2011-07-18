package de.jeha.spring_hibernate_hazelcast_webapp.struts2.actions;

import java.util.Random;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.jeha.spring_hibernate_hazelcast_webapp.struts2.bl.GenericDao;
import de.jeha.spring_hibernate_hazelcast_webapp.struts2.entities.User;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory
			.getLogger(IndexAction.class);

	@Resource
	private GenericDao genericDao;

	private String currentUsername;

	private static final Random GENERATOR = new Random();

	private Long userCount;

	private int createUserCount;
	
	private Long queryUserId;

	public Long getQueryUserId() {
		return queryUserId;
	}

	public void setQueryUserId(Long queryUserId) {
		this.queryUserId = queryUserId;
	}

	@Override
	public String execute() throws Exception {
		return Action.SUCCESS;
	}

	private User createRandomUser() {
		User u = new User();
		u.setUsername("u" + System.currentTimeMillis());
		u.setEmail(u.getUsername() + "@example.org");
		LOG.debug("new random user = " + u.getUsername());
		genericDao.persist(u);
		return u;
	}

	public String createXRandomUsers() {
		LOG.debug("create " + createUserCount + "users ... ");

		for (int i = 0; i < createUserCount; i++) {
			setCurrentUsername(createRandomUser().getUsername());
		}
		return Action.SUCCESS;
	}

	public String queryRandomUser() {
		CriteriaBuilder cb = genericDao.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
		countQuery.select(cb.count(countQuery.from(User.class)));

		userCount = genericDao.findSingle(countQuery);
		LOG.debug("userCount = " + userCount);

		User u = genericDao.get(User.class,
				(long) (GENERATOR.nextInt(userCount.intValue()) + 1));

		LOG.debug("user = " + u);
		currentUsername = u.getUsername();

		return Action.SUCCESS;
	}
	
	public String queryUserX() {
		User u = genericDao.get(User.class, queryUserId);
		LOG.debug("user = " + u);
		currentUsername = u.getUsername();
		return Action.SUCCESS;
	}

	public void setCurrentUsername(String currentUsername) {
		this.currentUsername = currentUsername;
	}

	public String getCurrentUsername() {
		return currentUsername;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setCreateUserCount(int createUserCount) {
		this.createUserCount = createUserCount;
	}

	public int getCreateUserCount() {
		return createUserCount;
	}

}
