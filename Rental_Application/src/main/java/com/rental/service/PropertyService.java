package com.rental.service;

import java.util.List;

import com.rental.entities.Property;
import com.rental.entities.PropertyDTO;
import com.rental.entities.PropertyDTO2;
import com.rental.exceptions.LandLordException;
import com.rental.exceptions.PropertyException;

public interface PropertyService {

	public Property addPropertyWithoutLandLord(PropertyDTO2 prt) throws PropertyException;
	
	public Property addPropertyWithLandLord(PropertyDTO prt) throws PropertyException;
	
	public List<Property> getAllPropetyOfALandLord(Integer landlordId) throws LandLordException;
	
	public List<Property> searchPropertyBasedOnLocation(String location) throws PropertyException;
	
	public Property getPropertyById(Integer propertyID) throws PropertyException;
	
	public List<Property> getAllProperties() throws PropertyException;
	
	public List<Property> getSortedPropertyListWithField(String field, String direction);
	
	public Property deleteProperty(Integer pid) throws PropertyException;
}
