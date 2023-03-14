package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.exceptions.LandLordException;
import com.rental.repository.LandLordRepository;

@Service
public class LandLordImpl implements LandLordService {
	
	@Autowired
	private LandLordRepository lrep;

	@Override
	public LandLord addLandLord(LandLord ld) throws LandLordException {
		
		return lrep.save(ld);
	}

	@Override
	public LandLord getLandLordByID(Integer landlordId) throws LandLordException {
		Optional<LandLord> opt=lrep.findById(landlordId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new LandLordException("LandLord with id: "+landlordId+" not found");
	}

	@Override
	public List<LandLord> getAllLandLord() throws LandLordException {
		List<LandLord> li=lrep.findAll();
		if(li.size()==0) {
			throw new LandLordException("There are no landlords");
		}
		return li;
	}

}
