package com.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entities.Property;
import com.rental.entities.PropertyDTO;
import com.rental.entities.PropertyDTO2;
import com.rental.exceptions.LandLordException;
import com.rental.exceptions.PropertyException;
import com.rental.service.PropertyService;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService pser;
	
	@PostMapping("/propertyWithoutlandlord")
	public ResponseEntity<Property> addPropertyWithoutLandLord(@RequestBody PropertyDTO2 prt) throws PropertyException{
		Property p=pser.addPropertyWithoutLandLord(prt);
		return new ResponseEntity<Property>(p,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/property")
	public ResponseEntity<Property> addPropertyWithLandLord(@RequestBody PropertyDTO prt) throws PropertyException{
		Property p=pser.addPropertyWithLandLord(prt);
		return new ResponseEntity<Property>(p,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/propertyBylandlordID/{landlordId}")
	public ResponseEntity<List<Property>> getAllPropetyOfALandLord(@PathVariable("landlordId") Integer landlordId) throws LandLordException{
		List<Property> li=pser.getAllPropetyOfALandLord(landlordId);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/propertyByLocation/{location}")
	public ResponseEntity<List<Property>> searchPropertyBasedOnLocation(@PathVariable("location") String location) throws PropertyException{
		List<Property> li=pser.searchPropertyBasedOnLocation(location);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/propertyByPropertyID/{propertyID}")
	public ResponseEntity<Property> getPropertyById(@PathVariable("propertyID") Integer propertyID) throws PropertyException{
		Property p=pser.getPropertyById(propertyID);
		return new ResponseEntity<Property>(p,HttpStatus.OK);
	}
	
	@GetMapping("/propertyAll")
	public ResponseEntity<List<Property>> getAllProperties() throws PropertyException{
		List<Property> li=pser.getAllProperties();
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getSortedProperties/{field}")
	public ResponseEntity<List<Property>> getSortedPropertyListWithField(@PathVariable("field") String field, @RequestParam("direction") String direction){
		List<Property> li= pser.getSortedPropertyListWithField(field, direction);
		return new ResponseEntity<List<Property>>(li,HttpStatus.OK);
	}
	
	@DeleteMapping("/propertyByPropertyID/{propertyID}")
	public ResponseEntity<Property> deletePropertyById(@PathVariable("propertyID") Integer propertyID) throws PropertyException{
		Property p=pser.deleteProperty(propertyID);
		return new ResponseEntity<Property>(p,HttpStatus.OK);
	}
}
