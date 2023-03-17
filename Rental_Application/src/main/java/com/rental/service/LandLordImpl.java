package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.entities.Property;
import com.rental.exceptions.LandLordException;
import com.rental.exceptions.PropertyException;
import com.rental.repository.LandLordRepository;
import com.rental.repository.PropertyRepository;

@Service
public class LandLordImpl implements LandLordService {
	
	@Autowired
	private LandLordRepository lrep;
	
	@Autowired
	private PropertyRepository prep;

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

	@Override
	public LandLord addLandLordWithProperty(LandLord ld, Integer propertyID)
			throws LandLordException, PropertyException {
		Optional<Property> opt=prep.findById(propertyID);
		if(opt.isEmpty()) {
			throw new PropertyException("There are no property by id: "+propertyID);
		}
		Property p=opt.get();
		ld.getProperties().add(p);
		return lrep.save(ld);
	}

	@Override
	public LandLord deleteLandLord(Integer landlordId) throws LandLordException {
		Optional<LandLord> opt=lrep.findById(landlordId);
		if(opt.isPresent()) {
			LandLord l=opt.get();
			lrep.delete(l);
			return l;
		}
		throw new LandLordException("LandLord with id: "+landlordId+" not found");
	}

}
