package com.dk.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.model.Order;
import com.dk.model.Picture;
import com.dk.model.User;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Order> getByUsername(User username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Order where username = :username ");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		return list;
	}

	@Override
	public List<Order> getByPictureId(Picture id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Order where picture_id = :id ");
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<Order> list = query.list();
		return list;
	}

	@Override
	public void saveOrUpdateOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
	}

}
