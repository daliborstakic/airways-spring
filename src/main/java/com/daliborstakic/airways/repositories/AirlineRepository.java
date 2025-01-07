package com.daliborstakic.airways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.airways.model.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
