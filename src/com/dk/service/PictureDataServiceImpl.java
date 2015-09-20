package com.dk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.dao.PictureDAO;
import com.dk.dao.PictureDataDAO;
import com.dk.model.Picture;
import com.dk.model.PictureData;

@Service
@Transactional
public class PictureDataServiceImpl implements PictureDataService {
	
	@Autowired
	PictureDataDAO pictureDataDAO;
	
	public void setPictureDataDAO(PictureDataDAO pictureDataDAO) {
		this.pictureDataDAO = pictureDataDAO;
	}

	@Override
	@Transactional
	public PictureData getPictureData(int id) {
		return pictureDataDAO.getPictureData(id);
	}

	@Override
	public void SaveOrUpdatePictureData(PictureData pictureData) {
		pictureDataDAO.saveOrUpdate(pictureData);
	}

	@Override
	public void deletePictureData(PictureData pictureData) {
		pictureDataDAO.deleteData(pictureData);
	}

}
