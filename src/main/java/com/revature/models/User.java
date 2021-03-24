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
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	int userId;
	
	@Column(name="USERNAME", unique=true, nullable=false)
	String username;
	
	@Column(name="PASSWORD", nullable=false)
	String password;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to UserRoles
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="UserRole_FK")
	private UserRole userRoleHolder;
	
	//Link to Portfolios
	@OneToMany(mappedBy="playerHolder", fetch	= FetchType.LAZY)
	private List<Portfolio> portfolioList = new ArrayList<Portfolio>();
}
