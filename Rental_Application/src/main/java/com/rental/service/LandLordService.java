package com.rental.service;

import java.util.List;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.exceptions.LandLordException;

public interface LandLordService {

	public LandLord addLandLord(LandLordDTO ld) throws LandLordException;
	
	public LandLord getLandLordByID(Integer landlordId) throws LandLordException;
	
	public List<LandLord> getAllLandLord() throws LandLordException;
}
