package com.dk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.dao.PictureThumbDAO;
import com.dk.model.PictureThumb;

@Service
@Transactional
public class PictureThumbServiceImpl implements PictureThumbService {

	@Autowired
	PictureThumbDAO pictureThumbDAO;
	
	public void setPictureThumbDAO(PictureThumbDAO pictureThumbDAO) {
		this.pictureThumbDAO = pictureThumbDAO;
	}

	@Override
	@Transactional
	public PictureThumb getPictureThumb(int id) {
		return pictureThumbDAO.getPictureData(id);
	}

	@Override
	public void SaveOrUpdatePictureThumb(PictureThumb pictureData) {
		pictureThumbDAO.saveOrUpdate(pictureData);
	}

	@Override
	public void deletePictureThumb(PictureThumb pictureThumb) {
		pictureThumbDAO.deleteData(pictureThumb);
	}

}
