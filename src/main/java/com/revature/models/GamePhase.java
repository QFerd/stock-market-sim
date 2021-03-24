package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GAME_PHASES")
public class GamePhase {
	
	@Id
	int phaseId;
	
	@Column(name="PHASE_NAME", unique=true, nullable=false)
	String phaseName;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	@OneToMany(mappedBy="gamePhaseHolder", fetch	= FetchType.LAZY)
	private List<Game> gameList = new ArrayList<Game>();
}
