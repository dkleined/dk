package com.dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.dao.UserDAO;
import com.dk.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
 

	@Override
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	public void SaveOrUpdateUser(User user) {
		userDAO.saveOrUpdate(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}

}
