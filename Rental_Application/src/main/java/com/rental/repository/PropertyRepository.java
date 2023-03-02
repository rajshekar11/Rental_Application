package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{
	
}
