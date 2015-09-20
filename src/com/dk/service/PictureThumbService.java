package com.dk.service;

import com.dk.model.PictureThumb;

public interface PictureThumbService {

	PictureThumb getPictureData(int id);

	void SaveOrUpdatePictureData(PictureThumb picture);

	void deletePictureData(int id);

}
