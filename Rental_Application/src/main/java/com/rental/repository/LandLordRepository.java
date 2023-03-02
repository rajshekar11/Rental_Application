package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entities.LandLord;

@Repository
public interface LandLordRepository extends JpaRepository<LandLord, Integer> {

}
