package com.revature.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}
	
	@Override
	public boolean register(User user) {
		try {
		sessionFactory.getCurrentSession().save(user);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Unable to register user, returning false.");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("Attempting to list all users.");
		try {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users");
		List<User> users = query.list(); //May be dangerous typecasting.
		return users;
		} catch (Exception e) {
			logger.info("Unable to list all users, returning null.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eq("username", username));
			User user = (User) crit.uniqueResult();
			if (user != null) {
				return user;
			}
			else {
				logger.info("Attempted to get user, user was not found, returning null.");
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
	}

}
	
/*	public List<User> getUserByClassroom(int id){
		
	}
*/
}
