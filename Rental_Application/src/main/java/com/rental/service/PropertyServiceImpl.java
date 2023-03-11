package com.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entities.LandLord;
import com.rental.entities.Property;
import com.rental.entities.PropertyDTO;
import com.rental.entities.PropertyDTO2;
import com.rental.exceptions.LandLordException;
import com.rental.exceptions.PropertyException;
import com.rental.repository.LandLordRepository;
import com.rental.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyRepository prep;
	
	@Autowired
	private LandLordRepository lrep;

	@Override
	public Property addPropertyWithoutLandLord(PropertyDTO2 prt) throws PropertyException {
		Property p=new Property();
		p.setLocation(prt.getLocation());
		p.setPrice(prt.getPrice());
		p.setPtype(prt.getPtype());
		return prep.save(p);
	}

	@Override
	public Property addPropertyWithLandLord(PropertyDTO prt) throws PropertyException {
		Optional<LandLord> opt=lrep.findById(prt.getLandlordId());
		if(opt.isEmpty()) {
			throw new PropertyException("There are no LandLord by ID: "+prt.getLandlordId());
		}
		LandLord ld=opt.get();
		Property p=new Property();
		p.setLandlord(ld);
		p.setLocation(prt.getLocation());
		p.setPrice(prt.getPrice());
		p.setPtype(prt.getPtype());
		return prep.save(p);
	}

	@Override
	public List<Property> getAllPropetyOfALandLord(Integer landlordId) throws LandLordException {
		Optional<LandLord> opt=lrep.findById(landlordId);
		if(opt.isEmpty()) {
			throw new LandLordException("There are no LandLord by ID: "+landlordId);
		}
		LandLord ld=opt.get();
		Optional<List<Property>> opt2=prep.findByLandlord(ld);
		if(opt2.isPresent()) {
			return opt2.get();
		}
		throw new LandLordException("There are no Properties owned by landlord: "+ld.getFirstName());
	}

	@Override
	public List<Property> searchPropertyBasedOnLocation(String location) throws PropertyException {
		Optional<List<Property>> opt2=prep.findByLocation(location);
		if(opt2.isPresent()) {
			List<Property> li=opt2.get();
			if(li.size()==0) {
				throw new PropertyException("There are no Properties for the given location: "+location);
			}
			return opt2.get();
		}
		throw new PropertyException("There are no Properties for the given location: "+location);
	}

	@Override
	public Property getPropertyById(Integer propertyID) throws PropertyException {
		Optional<Property> opt=prep.findById(propertyID);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new PropertyException("There are no property by property ID: "+propertyID);
	}

}