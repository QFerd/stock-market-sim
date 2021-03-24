package com.revature.service;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	
	public boolean register(User user);
	
	
	public List<User> getAllUsers();
	
	public User getUser(String username);
	
}
