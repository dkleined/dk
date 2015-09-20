package com.dk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -7175758461005219245L;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "user_password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
}
