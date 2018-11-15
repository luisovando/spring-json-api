package com.luisovando.springboot.app.domain.model;

import java.io.Serializable;
import java.util.Date;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonApiId
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private Date createdAt;

	public User() {
	}

	public User(String firstName, String lastName, String email) {
		this.id = 1L;
		this.createdAt = new Date();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
