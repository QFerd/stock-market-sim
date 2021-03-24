package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository("positionRepository")
@Transactional
public class PositionRepositoryImpl implements PositionRepository{
	private static Logger logger = Logger.getLogger(PositionRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PositionRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
}

/*
 * Sample Method Stubs below (from UserRepositoryImpl()).
	
	@Override
	public void register(User user) {
		logger.info("Attempting to register user.");
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("Attempting to list all users.");
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(String username) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username))
					.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
	}

}
 */
