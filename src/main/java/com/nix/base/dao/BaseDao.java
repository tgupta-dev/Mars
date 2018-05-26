package com.nix.base.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;


public interface BaseDao<T> {

	List<T> read(String sqlQuery, Object[] args, RowMapper<T> rowMapper);

	int create(String sqlQuery, Object[] args);

	int update(String sqlQuery, Object[] args);

	int delete(String sqlQuery, Object[] args);
}
