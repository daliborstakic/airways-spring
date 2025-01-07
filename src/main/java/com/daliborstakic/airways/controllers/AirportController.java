package com.daliborstakic.airways.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.airways.model.Airport;
import com.daliborstakic.airways.repositories.AirportRepository;

@RestController
@RequestMapping("/airports")
public class AirportController {
	@Autowired
	private AirportRepository airRepo;

	@GetMapping("/all")
	public List<Airport> allAirports() {
		return airRepo.findAll();
	}

	@GetMapping("/{id}")
	public Airport findAirport(@PathVariable("id") Integer id) {
		System.out.println("Jovan");
		return airRepo.getReferenceById(id);
	}
}
