package com.egen.service;

import java.util.List;

import com.egen.entity.UserEntity;

public interface UserService {
	
	public List<UserEntity> getAllUsers();
	public void addUser(UserEntity user);
	public void updateUser(UserEntity user);

}
