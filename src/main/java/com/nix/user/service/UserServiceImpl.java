package com.nix.user.service;

import java.util.List;

import com.nix.user.dao.UserDao;
import com.nix.user.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User findByUserId(long id) {
		User user = null;
		try {
			user = userDao.findByUserId(id);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public User findByUsername(String username) {
		User user = null;
		try {
			user = userDao.findByUsername(username);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public User createUser(User user) {
		if (findByUsername(user.getUsername()) != null) {
			return null;
		}
		return userDao.createUser(user);
	}

	public User updateUser(User newUser) {
		User oldUser = null;
		try {
			oldUser = userDao.findByUserId(newUser.getUserId());
			long userId = userDao.updateUser(oldUser, newUser);
			newUser = userDao.findByUserId(userId);
		} catch (Exception e) {
			newUser = null;
		}
		return newUser;
	}

	public User deleteUser(long id) {
		User user = null;
		try {
			user = userDao.findByUserId(id);
			user = userDao.deleteUser(user);
		} catch (Exception e) {
			user = null;
		}
		return user;
	}
}
