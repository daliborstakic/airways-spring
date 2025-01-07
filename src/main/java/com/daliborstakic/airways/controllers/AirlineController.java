package com.daliborstakic.airways.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.airways.model.Airline;
import com.daliborstakic.airways.repositories.AirlineRepository;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	@Autowired
	private AirlineRepository airlineRepo;

	@GetMapping("/all")
	public List<Airline> allAirlines() {
		return airlineRepo.findAll();
	}
}
