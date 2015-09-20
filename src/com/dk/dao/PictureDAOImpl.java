package com.dk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.model.Picture;
import com.dk.model.User;

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
	public void deletePicture(Picture picture) {
		sessionFactory.getCurrentSession().delete(picture);
	}

	@Override
	public List<Picture> getByUsername(User username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Picture where username = :username ");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Picture> list = query.list();
		return list;
	}

}
