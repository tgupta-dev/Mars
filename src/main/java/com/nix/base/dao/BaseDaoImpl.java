package com.nix.base.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<T> read(String sqlQuery, Object[] args, RowMapper<T> rowMapper) {

		return jdbcTemplate.query(sqlQuery, args, rowMapper);
	}

	public int create(String sqlQuery, Object[] args) {

		return jdbcTemplate.update(sqlQuery, args);
	}

	public int update(String sqlQuery, Object[] args) {

		return jdbcTemplate.update(sqlQuery, args);
	}

	public int delete(String sqlQuery, Object[] args) {

		return jdbcTemplate.update(sqlQuery, args);
	}

}
