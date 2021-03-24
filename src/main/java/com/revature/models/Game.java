package com.revature.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gameSequence")
	@SequenceGenerator(name="gameSequence", sequenceName="GAME_SEQ", allocationSize=1)
	int gameId;
	
	@Column(name="GAME_START_DATE", nullable=false)
	LocalDate gameStartDate;
	
	@Column(name="GAME_START_DATE", nullable=false)
	LocalDate gameCurrentDate;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to GamePhase
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="GamePhase_FK")
	private GamePhase gamePhaseHolder;
	
	//Link to Portfolio
	@OneToMany(mappedBy="gameHolder", fetch = FetchType.LAZY)
	private List<Portfolio> portfolioList = new ArrayList<Portfolio>();
}	
