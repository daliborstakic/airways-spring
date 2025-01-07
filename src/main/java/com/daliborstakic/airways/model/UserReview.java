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
 * The persistent class for the userreviews database table.
 * 
 */
@Entity
@Table(name = "userreviews")
@NamedQuery(name = "Userreview.findAll", query = "SELECT u FROM Userreview u")
public class UserReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	private Integer rating;

	@Column(name = "review_text")
	private String reviewText;

	// bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name = "airport_id")
	private Airport airport;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserReview() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return this.reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
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