package com.egen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.dao.UserDAO;
import com.egen.entity.UserEntity;
import com.egen.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = null;
		users = userDAO.getAllUsers();
		return users;
	}

	public void updateUser(UserEntity user) {
		userDAO.updateUser(user);
		
	}

	public void addUser(UserEntity user) {
		userDAO.addUser(user);		
	}

}
