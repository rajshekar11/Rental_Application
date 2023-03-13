package com.rental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rental.entities.LandLord;
import com.rental.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>,PagingAndSortingRepository<Property, Integer>{
	
	public Optional<List<Property>> findByLandlord(LandLord landlord);
	
	public Optional<List<Property>> findByLocation(String location);
}
