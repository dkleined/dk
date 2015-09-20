package com.dk.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dk.model.PictureData;

public class PictureDataDAOImpl implements PictureDataDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PictureData getPictureData(int id) {
		return (PictureData) sessionFactory.getCurrentSession().get(PictureData.class, id);
	}

	@Override
	public void saveOrUpdate(PictureData pictureData) {
		sessionFactory.getCurrentSession().saveOrUpdate(pictureData);
		
	}

	@Override
	public void deleteData(PictureData pictureData) {
		sessionFactory.getCurrentSession().delete(pictureData);
		
	}

}
