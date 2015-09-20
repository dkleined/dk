package com.dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.dao.PictureDAO;
import com.dk.model.Picture;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
	
	@Autowired
	PictureDAO pictureDAO;
	
	public void setPictureDAO(PictureDAO pictureDAO) {
		this.pictureDAO = pictureDAO;
	}

	@Override
	public Picture getPicture(int id) {
		return pictureDAO.getPicture(id);
	}

	@Override
	public void SaveOrUpdatePicture(Picture picture) {
		pictureDAO.saveOrUpdate(picture);
	}

	@Override
	public List<Picture> getPictures() {
		return pictureDAO.getPictures();
	}

	@Override
	public void deletePicture(int id) {
		pictureDAO.deletePicture(id);
	}

}
