package com.dk.dao;

import com.dk.model.PictureData;

public interface PictureDataDAO {

	public PictureData getPictureData(int od);

	public void saveOrUpdate(PictureData picture);

	public void deleteData(int id);

}
