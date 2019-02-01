package com.bridgelabz.spring.service;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.spring.dao.UserDao;
import com.bridgelabz.spring.model.UserDetails;

@Service
public class UserServiceImlp implements UserService  {

	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean register(UserDetails user, HttpServletRequest request) {
		int id = userDao.register(user);
		if (id > 0) {
			return true;
		}
		return false;
}

	}

