package com.dk.service;

import java.util.List;

import com.dk.model.Picture;
import com.dk.model.User;

public interface PictureService {

	Picture getPicture(int id);

	void SaveOrUpdatePicture(Picture picture);

	List<Picture> getPictures();

	void deletePicture(Picture picture);

	List<Picture> getByUsername(User username);
}
