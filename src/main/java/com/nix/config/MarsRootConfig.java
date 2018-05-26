package com.nix.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nix.user.dao.UserDao;
import com.nix.user.dao.UserDaoImpl;
import com.nix.user.service.UserService;
import com.nix.user.service.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nix")
public class MarsRootConfig {

	@Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
    
	    BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost:3306/venusdb");
	    ds.setUsername("tgadmin");
	    ds.setPassword("passw0rd");
        return ds;
    }
	
	@Bean
    public UserDao userDao() {
		UserDaoImpl userDao = new UserDaoImpl();
    	userDao.setDataSource(dataSource());
        return userDao;
    }
	
	@Bean
    public UserService userService() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(userDao());
        return userService;
    }
    
    
}