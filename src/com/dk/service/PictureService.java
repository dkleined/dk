package com.dk.service;

import java.util.List;

import com.dk.model.Picture;

public interface PictureService {

	Picture getPicture(int id);

	void SaveOrUpdatePicture(Picture picture);

	List<Picture> getPictures();

	void deletePicture(int id);

}
