package com.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entities.LandLord;
import com.rental.entities.LandLordDTO;
import com.rental.exceptions.LandLordException;
import com.rental.service.LandLordService;

@RestController
public class LandLordController {

	@Autowired
	private LandLordService lser;
	
	@PostMapping("/landlord")
	public ResponseEntity<LandLord> addLandLord(@RequestBody LandLordDTO ld) throws LandLordException{
		LandLord l=lser.addLandLord(ld);
		return new ResponseEntity<LandLord>(l,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("landlord/{landlordId}")
	public ResponseEntity<LandLord> getLandLordByID(@PathVariable("landlordId") Integer landlordId) throws LandLordException{
		LandLord l=lser.getLandLordByID(landlordId);
		return new ResponseEntity<LandLord>(l,HttpStatus.OK);
	}
	
	@GetMapping("landlordall")
	public ResponseEntity<List<LandLord>> getAllLandLord() throws LandLordException{
		List<LandLord> li=lser.getAllLandLord();
		return new ResponseEntity<List<LandLord>>(li,HttpStatus.OK);
	}
}
