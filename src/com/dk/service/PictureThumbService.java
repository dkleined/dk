package com.dk.service;

import com.dk.model.PictureThumb;

public interface PictureThumbService {

	PictureThumb getPictureThumb(int id);

	void SaveOrUpdatePictureThumb(PictureThumb picture);

	void deletePictureThumb(PictureThumb pictureThumb);

}
