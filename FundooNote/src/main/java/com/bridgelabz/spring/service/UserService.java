package com.bridgelabz.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.spring.model.User;

public interface UserService {
	public boolean register(User user, HttpServletRequest request);
}
