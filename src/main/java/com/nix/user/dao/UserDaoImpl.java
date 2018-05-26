package com.nix.user.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nix.base.dao.BaseDaoImpl;
import com.nix.user.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	// private Logger logger = Logger.getLogger(UserDaoImpl.class);

	public void setDataSource(DataSource dataSource) {
		setJdbcTemplate(new JdbcTemplate(dataSource));
	}

	public List<User> getAllUsers() {
		String sqlQuery = "select * from user";
		Object[] args = new Object[] {};

		return read(sqlQuery, args, new BeanPropertyRowMapper<User>(User.class));
	}

	public User findByUserId(long id) {
		String sqlQuery = "select * from user where user_id=?";
		Object[] args = new Object[] { id };

		return read(sqlQuery, args, new BeanPropertyRowMapper<User>(User.class)).get(0);
	}

	public User findByUsername(String username) {
		String sqlQuery = "select * from user where username=?";
		Object[] args = new Object[] { username };

		return read(sqlQuery, args, new BeanPropertyRowMapper<User>(User.class)).get(0);
	}

	public User createUser(User user) {
		String sqlQuery = "INSERT INTO user (user_id, username, firstname, lastname, email, status) "
				+ "VALUES (?,?,?,?,?,?)";

		Object[] args = new Object[] { user.getUserId(), user.getUsername(), user.getFirstname(), user.getLastname(),
				user.getEmail(), user.getStatus() };

		int out = create(sqlQuery, args);

		if (out != 0) {
			return user;
		} else {
			return null;
		}
	}

	public long updateUser(User oldUser, User newUser) {
		String sqlQuery = "UPDATE user SET username=?, firstname=?, lastname=?, email=?, status=? WHERE user_id=?";

		Object[] args = new Object[] { newUser.getUsername() != null ? newUser.getUsername() : oldUser.getUsername(),
				newUser.getFirstname() != null ? newUser.getFirstname() : oldUser.getFirstname(),
				newUser.getLastname() != null ? newUser.getLastname() : oldUser.getLastname(),
				newUser.getEmail() != null ? newUser.getEmail() : oldUser.getEmail(),
				newUser.getStatus() != 0 ? newUser.getStatus() : oldUser.getStatus(), newUser.getUserId() };

		int out = update(sqlQuery, args);
		if (out != 0) {
			return newUser.getUserId();
		} else {
			return 0;
		}
	}

	public User deleteUser(User user) {
		String sqlQuery = "delete from user where user_id=?";
		Object[] args = new Object[] { user.getUserId() };

		int out = delete(sqlQuery, args);
		if (out != 0) {
			return user;
		} else {
			return null;
		}
	}

}
