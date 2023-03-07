package com.rental.service;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.exceptions.LandLordException;

public interface LandLordService {

	public LandLord addLandLord(LandLordDTO ld) throws LandLordException;
	
	public LandLord getLandLordByID(Integer landlordId) throws LandLordException;
}
