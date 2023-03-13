package com.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rental.entities.Booking;
import com.rental.entities.LandLord;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select bookings from Property where pId=?1")
	public List<Booking> getAllBookingsBypId(Integer pId);
}
