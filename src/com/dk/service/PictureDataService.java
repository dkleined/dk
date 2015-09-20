package com.dk.service;

import com.dk.model.PictureData;

public interface PictureDataService {

	PictureData getPictureData(int id);

	void SaveOrUpdatePictureData(PictureData picture);

	void deletePictureData(PictureData pictureData);

}
