package com.dk.dao;

import java.util.List;

import com.dk.model.Picture;

public interface PictureDAO {

	public List<Picture> getPictures();

	public Picture getPicture(int id);

	public void saveOrUpdate(Picture picture);

	public void deletePicture(int id);

}
