package com.dk.service;

import java.util.List;

import com.dk.model.User;

public interface UserService {

	User getUser(String username);

	void SaveOrUpdateUser(User user);

	List<User> getUsers();

	void deleteUser(User user);
}