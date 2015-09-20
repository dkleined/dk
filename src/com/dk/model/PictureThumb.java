package com.dk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "picture_thumb")
public class PictureThumb implements Serializable {

	private static final long serialVersionUID = -2010475835621696280L;
	private Picture id;
	private byte[] data;
	private int pictureId;
	
	@Id
	@Column(name = "id")
	public int getPictureId() {
		return pictureId;
	}
	
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public Picture getId() {
		return id;
	}

	public void setId(Picture id) {
		this.id = id;
	}

	@Column(name = "picture_data")
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
