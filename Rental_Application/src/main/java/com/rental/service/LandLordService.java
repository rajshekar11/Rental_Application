package com.rental.service;

import java.util.List;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.exceptions.LandLordException;
import com.rental.exceptions.PropertyException;

public interface LandLordService {

	public LandLord addLandLord(LandLord ld) throws LandLordException;
	
	public LandLord addLandLordWithProperty(LandLord ld,Integer propertyID) throws LandLordException,PropertyException;
	
	public LandLord getLandLordByID(Integer landlordId) throws LandLordException;
	
	public List<LandLord> getAllLandLord() throws LandLordException;
	
	public LandLord deleteLandLord(Integer landlordId) throws LandLordException;
}
