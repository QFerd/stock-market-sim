package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="POSITIONS")
public class Position {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="positionSequence")
	@SequenceGenerator(name="positionSequence", sequenceName="POSITION_SEQ", allocationSize=1)
	int positionId;
	
	@Column(name="STOCK_SYMBOL")
	String stockSymbol;
	
	@Column(name="QUANTITY")
	int quantity;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to portfolios
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="User_FK")
	private Portfolio portfolioHolder;


}
