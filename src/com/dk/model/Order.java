package com.dk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 8883587458510754336L;
	private int id;
	private User username;
	private Picture pictureId;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "picture_id")
	public Picture getPictureId() {
		return pictureId;
	}

	public void setPictureId(Picture pictureId) {
		this.pictureId = pictureId;
	}

	@ManyToOne
	@JoinColumn(name = "username")
	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	
}
