package com.dk.dao;

import com.dk.model.PictureThumb;

public interface PictureThumbDAO {

	public PictureThumb getPictureData(int od);

	public void saveOrUpdate(PictureThumb picture);

	public void deleteData(PictureThumb thumb);

}
