package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
