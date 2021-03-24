package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;

@Repository("portfolioRepository")
@Transactional
public class PortfolioRepositoryImpl implements PortfolioRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public PortfolioRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void newPortfolio(Portfolio portfolio) {
		logger.info("Attempting to add new portfolio to DB.");
		sessionFactory.getCurrentSession().save(portfolio);
	}

	@Override
	public double getTotalValue(User user, Game game) {
		return getStockValue(user, game) + getCashValue(user, game);
	}

	@Override
	public double getStockValue(User user, Game game) {
		Portfolio port = getPortfolio(user, game);
		port.getStockValue();
		return 0;
	}

	@Override
	public double getCashValue(User user, Game game) {
		Portfolio port = getPortfolio(user, game);	
		port.getCashValue();
		return 0;
	}

	@Override
	public Portfolio getPortfolio(User user, Game game) {
		try {
			//TODO: How am I going to do this?
		} catch (IndexOutOfBoundsException e) {
			logger.debug(e);
			return null;
		}
		return null;
	}

}

/*
 * 
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
