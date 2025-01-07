package com.daliborstakic.airways.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.airways.model.Route;
import com.daliborstakic.airways.repositories.RouteRepository;

@RestController
@RequestMapping("/routes")
public class RouteController {
	@Autowired
	private RouteRepository routeRepo;

	@GetMapping("/all")
	public List<Route> getRoutes() {
		return routeRepo.findAll();
	}
}
