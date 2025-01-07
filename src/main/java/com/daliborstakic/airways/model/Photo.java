package com.daliborstakic.airways.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the photos database table.
 * 
 */
@Entity
@Table(name = "photos")
@NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@Column(name = "photo_url")
	private String photoUrl;

	@Column(name = "uploaded_at")
	private Timestamp uploadedAt;

	// bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name = "airport_id")
	private Airport airport;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Photo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Timestamp getUploadedAt() {
		return this.uploadedAt;
	}

	public void setUploadedAt(Timestamp uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public Airport getAirport() {
		return this.airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}