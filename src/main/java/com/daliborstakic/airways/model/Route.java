package com.daliborstakic.airways.model;

import java.io.Serializable;

import org.locationtech.jts.geom.LineString;

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
 * The persistent class for the routes database table.
 * 
 */
@Entity
@Table(name = "routes")
@NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private Integer routeId;

	@Column(columnDefinition = "geometry(LineString,4326)")
	private LineString route;

	private Integer stops;

	// bi-directional many-to-one association to Airline
	@ManyToOne
	@JoinColumn(name = "airline_id")
	private Airline airline;

	// bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name = "destination")
	private Airport airport1;

	// bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name = "source")
	private Airport airport2;

	public Route() {
	}

	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Object getRoute() {
		return this.route;
	}

	public void setRoute(LineString route) {
		this.route = route;
	}

	public Integer getStops() {
		return this.stops;
	}

	public void setStops(Integer stops) {
		this.stops = stops;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getAirport1() {
		return this.airport1;
	}

	public void setAirport1(Airport airport1) {
		this.airport1 = airport1;
	}

	public Airport getAirport2() {
		return this.airport2;
	}

	public void setAirport2(Airport airport2) {
		this.airport2 = airport2;
	}

}