package com.dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.dao.OrderDAO;
import com.dk.model.Order;
import com.dk.model.Picture;
import com.dk.model.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public List<Order> getByUsername(User username) {
		return orderDAO.getByUsername(username);
	}

	@Override
	public List<Order> getByPictureId(Picture id) {
		return orderDAO.getByPictureId(id);
	}

	@Override
	public void saveOrUpdateOrder(Order order) {
		orderDAO.saveOrUpdateOrder(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);
	}

}
