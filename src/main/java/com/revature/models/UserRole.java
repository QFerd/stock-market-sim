package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRole {
	
	@Id
	int roleId;
	
	@Column(name="ROLE_NAME", unique=true, nullable=false)
	String roleName;
	
	//-----------------DEFINE OUR PK/FK RELATIONSHIPS
	
	//Link to Users
	@OneToMany(mappedBy="userRoleHolder", fetch	= FetchType.LAZY)
	private List<User> userList = new ArrayList<User>();
	
	
	
	
}
