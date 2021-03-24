package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
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
		sessionFactory.getCurrentSession().save(user);
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAnUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
