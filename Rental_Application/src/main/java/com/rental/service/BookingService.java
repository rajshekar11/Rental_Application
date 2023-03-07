package com.rental.service;

import com.rental.entities.Booking;
import com.rental.entities.BookingDTO;
import com.rental.exceptions.BookingException;

public interface BookingService {

	public String makeABooking(BookingDTO bkg) throws BookingException;
	
	public Booking getBookingDetails(Integer bkingID) throws BookingException;
}
