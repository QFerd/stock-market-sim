package com.revature.repository;

import java.util.List;

import com.revature.models.User;

public interface UserRepository {
	
	
	boolean register(User user);
	
	List<User> getAllUsers();
	
	User getAnUser(String username);
}
