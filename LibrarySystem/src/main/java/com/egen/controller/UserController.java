package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egen.entity.UserEntity;
import com.egen.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/allUsers", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> getAllUsers() {
		List<UserEntity> usersList = null;
		usersList = userService.getAllUsers();
		return usersList;
	}

	@RequestMapping(value="/updateUser{id}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable("id") long userId, @RequestBody UserEntity user) {
		user.setUserId(userId);
		userService.updateUser(user);

	}
    
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody UserEntity user) {
		userService.addUser(user);


	}

}
