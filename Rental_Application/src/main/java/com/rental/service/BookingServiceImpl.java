package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entities.Booking;
import com.rental.entities.BookingDTO;
import com.rental.entities.Property;
import com.rental.entities.Tenant;
import com.rental.exceptions.BookingException;
import com.rental.exceptions.PropertyException;
import com.rental.exceptions.TenantException;
import com.rental.repository.BookingRepository;
import com.rental.repository.PropertyRepository;
import com.rental.repository.TenantRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository brep;
	
	@Autowired
	private TenantRepository trep;
	
	@Autowired
	private PropertyRepository prep;
	
	@Override
	public Booking makeABooking(BookingDTO bkg) throws BookingException,TenantException,PropertyException {
		Optional<Tenant> opt=trep.findById(bkg.getTenantID());
		if(opt.isEmpty()) {
			throw new TenantException("There are no tenant by ID: "+bkg.getTenantID());
		}
		Tenant t=opt.get();
		Optional<Property> opt2=prep.findById(bkg.getPropertyId());
		if(opt2.isEmpty()) {
			throw new PropertyException("There are no properties by id: "+bkg.getPropertyId());
		}
		Property p=opt2.get();
		Booking bk=new Booking();
		bk.setNumberOfMonth(bkg.getNumberOfMonth());
		bk.setNumberOfTenant(bkg.getNumberOfTenant());
		bk.setProperty(p);
		bk.setTenant(t);
		
		return brep.save(bk);
	}

	@Override
	public Booking getBookingDetails(Integer bkingID) throws BookingException {
		Optional<Booking> opt=brep.findById(bkingID);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new BookingException("There are no booking by ID: "+bkingID);
	}

	@Override
	public Booking cancelBookingById(Integer bkingID) throws BookingException {
		Optional<Booking> opt=brep.findById(bkingID);
		if(opt.isPresent()) {
			Booking b=opt.get();
			brep.delete(b);
			return b;
		}
		throw new BookingException("There are no booking by ID: "+bkingID);
	}

	@Override
	public List<Booking> getAllBookings() throws BookingException {
		List<Booking> li=brep.findAll();
		if(li.size()==0) {
			throw new BookingException("There are no bookings");
		}
		return li;
	}

	@Override
	public List<Booking> getAllBookingsOfAProperty(Integer pId) throws BookingException {
		List<Booking> li=brep.getAllBookingsBypId(pId);
		if(li.size()==0) {
			throw new BookingException("There are no bookings for this property");
		}
		return li;
	}

}
