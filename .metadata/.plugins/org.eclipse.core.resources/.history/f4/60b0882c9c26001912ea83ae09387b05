package com.bridgelabz.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.spring.dao.UserDao;
import com.bridgelabz.spring.model.User;

@Service
public class UserServiceImlp implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean register(User user, HttpServletRequest request) {
		int id = userDao.register(user);
		if (id > 0) {
			return true;
		}
		return false;
	}

	public User loginUser(String emailId, String password, HttpServletRequest request) {
		return userDao.loginUser(emailId, password);
	}

	public User updateUser(String emailId, User user, HttpServletRequest request) {
		User user2 = userDao.getUserByEmailId(emailId);
		if (user2 != null) {
			user2.setMobileNumber(user.getMobileNumber());
			user2.setName(user.getName());
			user2.setPassword(user.getPassword());
			userDao.updateUser(emailId, user2);
		}
		return user2;
	}

	public User deleteUser(String emailId, HttpServletRequest request) {
		User user2 = userDao.getUserByEmailId(emailId);
		if (user2 != null) {
			userDao.deleteUser(emailId);
		}
		return user2;
	}

}
