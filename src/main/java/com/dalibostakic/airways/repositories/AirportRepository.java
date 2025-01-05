package com.dalibostakic.airways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.airways.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
