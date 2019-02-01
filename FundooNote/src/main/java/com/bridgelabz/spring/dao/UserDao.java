package com.bridgelabz.spring.dao;

import java.util.List;

import com.bridgelabz.spring.model.User;

public interface UserDao {

	public int register(User user);

	public User login(User user);

	public boolean updateUser(User user);

	public List<User> getUsersList();

	public void deleteUser(String id);
}
