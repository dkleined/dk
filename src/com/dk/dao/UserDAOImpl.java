package com.dk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public User getUser(String username) {
		return (User) sessionFactory.getCurrentSession().get(User.class, username);
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
