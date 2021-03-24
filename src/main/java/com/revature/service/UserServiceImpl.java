package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean register(User user) {
		userRepository.register(user);
		return user.getUserId() != 0;
	}

	@Override
	public List<User> getAllUsers() {
		UserRepositoryImpl UserRepo = new UserRepositoryImpl();
		return UserRepo.getAllUsers();
	}

	@Override
	public User getUser(String username) {
		UserRepositoryImpl UserRepo = new UserRepositoryImpl();
		return UserRepo.getUser(username);
	}
	

}
