package com.dk.service;

import java.util.List;

import com.dk.model.Order;
import com.dk.model.Picture;
import com.dk.model.User;

public interface OrderService {

	public List<Order> getByUsername(User username);

	public List<Order> getByPictureId(Picture id);

	public void saveOrUpdateOrder(Order order);

	public void deleteOrder(Order order);

}
