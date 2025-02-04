package com.daliborstakic.airways.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Basic(optional = false)
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdAt;

	@NotNull(message = "Email cannot be null!")
	@NotEmpty(message = "Email cannot be empty!")
	@Email(message = "Email must be in a valid email format!")
	private String email;

	@Column(name = "password_hash")
	private String passwordHash;

	@Basic(optional = false)
	@Column(name = "updated_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp updatedAt;

	@NotNull(message = "Username cannot be null!")
	@NotEmpty(message = "Username cannot be empty!")
	@Size(min = 6, max = 20)
	private String username;

	// bi-directional many-to-one association to Photo
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Photo> photos;

	// bi-directional many-to-one association to Userreview
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Userreview> userreviews;

	public User() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setUser(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setUser(null);

		return photo;
	}

	public List<Userreview> getUserreviews() {
		return this.userreviews;
	}

	public void setUserreviews(List<Userreview> userreviews) {
		this.userreviews = userreviews;
	}

	public Userreview addUserreview(Userreview userreview) {
		getUserreviews().add(userreview);
		userreview.setUser(this);

		return userreview;
	}

	public Userreview removeUserreview(Userreview userreview) {
		getUserreviews().remove(userreview);
		userreview.setUser(null);

		return userreview;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Override
	public String getPassword() {
		return passwordHash;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}