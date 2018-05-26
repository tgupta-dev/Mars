package com.nix.user.service;

import java.util.List;

import com.nix.user.model.User;

public interface UserService {

	List<User> getAllUsers();

	User findByUserId(long id);

	User findByUsername(String username);

	User createUser(User user);

	User updateUser(User user);
	
	User deleteUser(long id);
}
