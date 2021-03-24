package com.revature.repository;

import com.revature.models.Game;
import com.revature.models.Portfolio;
import com.revature.models.User;

public class PortfolioRepositoryImpl implements PortfolioRepository{

	@Override
	public boolean newPortfolio(User user, Game game) {
		// TODO: Implementation of this one should be simple, just a matter of getting Hibernate to do the thing. Same thing each time.
		return false;
	}

	@Override
	public double getTotalValue(User user, Game game) {
		return getStockValue(user, game) + getCashValue(user, game);
	}

	@Override
	public double getStockValue(User user, Game game) {
		findPortfolio(user, game);
			//TODO: Implementation of this one should be simple, just a matter of getting Hibernate to do the thing.
		return 0;
	}

	@Override
	public double getCashValue(User user, Game game) {
		// TODO: Implementation of this one should be simple, just a matter of getting Hibernate to do the thing.
		return 0;
	}

	@Override
	public Portfolio findPortfolio(User user, Game game) {
		// TODO Auto-generated method stub
		return null;
	}

}
