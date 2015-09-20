package com.dk.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dk.model.PictureThumb;

public class PictureThumbDAOImpl implements PictureThumbDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PictureThumb getPictureData(int id) {
		return (PictureThumb) sessionFactory.getCurrentSession().get(PictureThumb.class, id);
	}

	@Override
	public void saveOrUpdate(PictureThumb pictureData) {
		sessionFactory.getCurrentSession().saveOrUpdate(pictureData);
		
	}

	@Override
	public void deleteData(int id) {
		sessionFactory.getCurrentSession().delete(id);
		
	}

}
