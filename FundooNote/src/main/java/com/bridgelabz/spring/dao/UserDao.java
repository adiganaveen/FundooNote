package com.bridgelabz.spring.dao;

import com.bridgelabz.spring.model.User;

public interface UserDao {

	public int register(User user);

	public User loginUser(String emailId, String password);

	public User getUserByEmailId(String emailId);

	public void updateUser(String emailId, User user);

	public void deleteUser(String emailId);

}
