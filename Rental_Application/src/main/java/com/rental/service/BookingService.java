package com.rental.service;

import java.util.List;

import com.rental.entities.Booking;
import com.rental.entities.BookingDTO;
import com.rental.exceptions.BookingException;
import com.rental.exceptions.PropertyException;
import com.rental.exceptions.TenantException;

public interface BookingService {

	public Booking makeABooking(BookingDTO bkg) throws BookingException,TenantException,PropertyException;
	
	public Booking getBookingDetails(Integer bkingID) throws BookingException;
	
	public Booking cancelBookingById(Integer bkingID) throws BookingException;
	
	public List<Booking> getAllBookingsOfAProperty(Integer pId) throws BookingException;
	
	public List<Booking> getAllBookings() throws BookingException;
	
}
