package com.revature.models;

import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="GAME")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameSequence")
	@SequenceGenerator(name="gameSequence", sequenceName="GAME_SEQ", allocationSize=1)
	int gameId;
	
	@Column(name="GAME_START_DATE", nullable=false)
	LocalDate gameStartDate;
	
	@Column(name="GAME_CURRENT_DATE", nullable=false)
	LocalDate gameCurrentDate;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to GamePhase
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="GamePhase_FK")
	private GamePhase gamePhaseHolder;
	
	//Link to Portfolio
	@OneToMany(mappedBy="gameHolder", fetch = FetchType.LAZY)
	private List<Portfolio> portfolioList = new ArrayList<Portfolio>();

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public LocalDate getGameStartDate() {
		return gameStartDate;
	}

	public void setGameStartDate(LocalDate gameStartDate) {
		this.gameStartDate = gameStartDate;
	}

	public LocalDate getGameCurrentDate() {
		return gameCurrentDate;
	}

	public void setGameCurrentDate(LocalDate gameCurrentDate) {
		this.gameCurrentDate = gameCurrentDate;
	}

	public GamePhase getGamePhaseHolder() {
		return gamePhaseHolder;
	}

	public void setGamePhaseHolder(GamePhase gamePhaseHolder) {
		this.gamePhaseHolder = gamePhaseHolder;
	}

	public List<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(List<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}
	
	
}	
