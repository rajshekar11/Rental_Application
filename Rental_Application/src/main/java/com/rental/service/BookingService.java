package com.rental.service;

import com.rental.entities.Booking;
import com.rental.entities.BookingDTO;
import com.rental.exceptions.BookingException;
import com.rental.exceptions.PropertyException;
import com.rental.exceptions.TenantException;

public interface BookingService {

	public String makeABooking(BookingDTO bkg) throws BookingException,TenantException,PropertyException;
	
	public Booking getBookingDetails(Integer bkingID) throws BookingException;
	
	public Booking cancelBookingById(Integer bkingID) throws BookingException;
	
}
