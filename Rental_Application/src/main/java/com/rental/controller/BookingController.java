package com.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entities.Booking;
import com.rental.entities.BookingDTO;
import com.rental.exceptions.BookingException;
import com.rental.exceptions.PropertyException;
import com.rental.exceptions.TenantException;
import com.rental.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bser;
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> makeABooking(@RequestBody BookingDTO bkg) throws BookingException,TenantException,PropertyException{
		Booking bk=bser.makeABooking(bkg);
		return new ResponseEntity<Booking>(bk,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/booking/{bkingID}")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable("bkingID") Integer bkingID) throws BookingException{
		Booking b=bser.getBookingDetails(bkingID);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/booking/{bkingID}")
	public ResponseEntity<Booking> cancelBookingById(@PathVariable("bkingID") Integer bkingID) throws BookingException{
		Booking b=bser.cancelBookingById(bkingID);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/bookingByProperty/{pId}")
	public ResponseEntity<List<Booking>> getAllBookingsOfAProperty(@PathVariable("pId") Integer pId) throws BookingException{
		List<Booking> li=bser.getAllBookingsOfAProperty(pId);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@GetMapping("/bookingAll")
	public ResponseEntity<List<Booking>> getAllBookings() throws BookingException{
		List<Booking> li=bser.getAllBookings();
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
}
