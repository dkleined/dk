package com.dk.dao;

import java.util.List;

import com.dk.model.User;

public interface UserDAO {
	public List<User> getUsers();

	public User getUser(String username);

	public void saveOrUpdate(User user);

	public void deleteUser(User user);
}
