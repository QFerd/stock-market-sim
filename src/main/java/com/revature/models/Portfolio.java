package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PORTFOLIOS")
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="portfolioSequence")
	@SequenceGenerator(name="portfolioSequence", sequenceName="PORTFOLIO_SEQ", allocationSize=1)
	int portfolioId;
	
	@Column(name="TOTAL_VALUE")
	double totalValue;
	
	@Column(name="STOCK_VALUE")
	double stockValue;
	
	@Column(name="CASH_VALUE")
	double cashValue;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to Users
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="User_FK")
	private User playerHolder;
	
	//Link to Games
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Game_FK")
	private Game gameHolder;
	
	//Link to position
	@OneToMany(mappedBy="portfolioHolder", fetch = FetchType.LAZY)
	private List<Position> positionList = new ArrayList<Position>();

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public double getCashValue() {
		return cashValue;
	}

	public void setCashValue(double cashValue) {
		this.cashValue = cashValue;
	}

	public User getPlayerHolder() {
		return playerHolder;
	}

	public void setPlayerHolder(User playerHolder) {
		this.playerHolder = playerHolder;
	}

	public Game getGameHolder() {
		return gameHolder;
	}

	public void setGameHolder(Game gameHolder) {
		this.gameHolder = gameHolder;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}
	
	
}
