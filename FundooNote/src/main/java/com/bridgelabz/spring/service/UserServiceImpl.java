package com.bridgelabz.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.spring.Utility.EmailUtil;
import com.bridgelabz.spring.Utility.TokenGenerator;
import com.bridgelabz.spring.dao.UserDao;
import com.bridgelabz.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
    private PasswordEncoder bcryptEncoder;

	@Autowired
	private EmailUtil emailUtil;
	
	@Transactional
	public boolean register(User user, HttpServletRequest request) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		int id = userDao.register(user);
		if (id > 0) {
			String token = tokenGenerator.generateToken(String.valueOf(id));
			System.out.println(token);
			StringBuffer requestUrl = request.getRequestURL();
            String activationUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/"));
            activationUrl = activationUrl + "/activationstatus/"+token;
			emailUtil.sendEmail("", "",activationUrl);
			return true;
		}
		return false;
	}

	@Transactional
	public User loginUser(String emailId, String password, HttpServletRequest request,HttpServletResponse response) {
		User user=userDao.loginUser(emailId);
		if(bcryptEncoder.matches(password, user.getPassword()) && user.isActivationStatus())
		{
			String token = tokenGenerator.generateToken(String.valueOf(user.getId()));
			response.setHeader("token", token);
			return user;
		}
		return null;
	}

	@Transactional
	public User updateUser(int id, User user, HttpServletRequest request) {
		User user2 = userDao.getUserById(id);
		if (user2 != null) {
			user2.setMobileNumber(user.getMobileNumber());
			user2.setName(user.getName());
			user2.setPassword(user.getPassword());
			user2.setPassword(bcryptEncoder.encode(user2.getPassword()));
			userDao.updateUser(id, user2);
		}
		return user2;
	}

	@Transactional
	public User deleteUser(int id, HttpServletRequest request) {
		User user2 = userDao.getUserById(id);
		if (user2 != null) {
			userDao.deleteUser(id);
		}
		return user2;
	}
	
	@Transactional
	public User activateUser(String token, HttpServletRequest request) {
		int id=tokenGenerator.verifyToken(token);
		User user=userDao.getUserById(id);
		if(user!=null)
		{
			user.setActivationStatus(true);
			userDao.updateUser(id, user);
		}
		return user;
	}
	

}
