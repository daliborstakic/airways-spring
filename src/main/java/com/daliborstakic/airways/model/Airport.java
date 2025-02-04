package com.daliborstakic.airways.model;

import java.io.Serializable;
import java.util.List;

import org.locationtech.jts.geom.Point;

import com.daliborstakic.airways.util.PointDeserializer;
import com.daliborstakic.airways.util.PointSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the airports database table.
 * 
 */
@Entity
@Table(name = "airports")
@NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a")
public class Airport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airport_id")
	private Integer airportId;

	private String city;

	private String country;

	@Column(columnDefinition = "geometry(Point, 4326)")
	@JsonSerialize(using = PointSerializer.class)
	@JsonDeserialize(using = PointDeserializer.class)
	private Point location;

	private String name;

	private String type;

	// bi-directional many-to-one association to Route
	@OneToMany(mappedBy = "airport1")
	@JsonIgnore
	private List<Route> routes1;

	// bi-directional many-to-one association to Route
	@JsonIgnore
	@OneToMany(mappedBy = "airport2")
	private List<Route> routes2;

	// bi-directional many-to-one association to Photo
	@OneToMany(mappedBy = "airport")
	private List<Photo> photos;

	// bi-directional many-to-one association to Userreview
	@OneToMany(mappedBy = "airport")
	private List<Userreview> userreviews;

	public Airport() {
	}

	public Integer getAirportId() {
		return this.airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Object getLocation() {
		return this.location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Route> getRoutes1() {
		return this.routes1;
	}

	public void setRoutes1(List<Route> routes1) {
		this.routes1 = routes1;
	}

	public Route addRoutes1(Route routes1) {
		getRoutes1().add(routes1);
		routes1.setAirport1(this);

		return routes1;
	}

	public Route removeRoutes1(Route routes1) {
		getRoutes1().remove(routes1);
		routes1.setAirport1(null);

		return routes1;
	}

	public List<Route> getRoutes2() {
		return this.routes2;
	}

	public void setRoutes2(List<Route> routes2) {
		this.routes2 = routes2;
	}

	public Route addRoutes2(Route routes2) {
		getRoutes2().add(routes2);
		routes2.setAirport2(this);

		return routes2;
	}

	public Route removeRoutes2(Route routes2) {
		getRoutes2().remove(routes2);
		routes2.setAirport2(null);

		return routes2;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setAirport(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setAirport(null);

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
		userreview.setAirport(this);

		return userreview;
	}

	public Userreview removeUserreview(Userreview userreview) {
		getUserreviews().remove(userreview);
		userreview.setAirport(null);

		return userreview;
	}

}