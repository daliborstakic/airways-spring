package com.daliborstakic.airways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.airways.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

}
