package com.dk.dao;

import java.util.List;

import com.dk.model.Order;
import com.dk.model.Picture;
import com.dk.model.User;

public interface OrderDAO {

	public List<Order> getByUsername(User username);

	public List<Order> getByPictureId(Picture id);

	public void saveOrUpdateOrder(Order order);

	public void deleteOrder(Order order);
}
