package com.csl.bmsri.userService;

import com.csl.bmsri.Models.User;

public interface UserService {

	public User findUserByEmail(String email);
	public void saveUser(User user);
	
	//public UserLoginBk findUserByEmail(String email); 
}