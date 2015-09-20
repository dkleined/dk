package com.dk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.model.Picture;

@Repository
@Transactional
public class PictureDAOImpl implements PictureDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public PictureDAOImpl() {
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> getPictures() {
		return (List<Picture>) sessionFactory.getCurrentSession().createCriteria(Picture.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public Picture getPicture(int id) {
		return (Picture) sessionFactory.getCurrentSession().get(Picture.class, id);
	}

	@Override
	public void saveOrUpdate(Picture picture) {
		sessionFactory.getCurrentSession().saveOrUpdate(picture);
	}

	@Override
	public void deletePicture(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
