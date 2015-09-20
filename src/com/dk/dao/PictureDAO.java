package com.dk.dao;

import java.util.List;

import com.dk.model.Picture;
import com.dk.model.User;

public interface PictureDAO {

	public List<Picture> getPictures();

	public Picture getPicture(int id);

	public void saveOrUpdate(Picture picture);

	public void deletePicture(Picture picture);
	
	public List<Picture> getByUsername(User username);

}
