package com.egen.dao;

import java.util.List;

import com.egen.entity.UserEntity;

public interface UserDAO {

	public List<UserEntity> getAllUsers();
	public void updateUser(UserEntity user);
	public void addUser(UserEntity user);
}
