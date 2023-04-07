package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.rental.entities.Tenant;

import com.rental.exceptions.TenantException;
import com.rental.service.TenantService;

import jakarta.validation.Valid;

@RestController
public class TenantController {
	
	@Autowired
	private TenantService tser;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@CrossOrigin(origins = "https://rentalapplication-prod.up.railway.app/tenant")
	@PostMapping("/tenant")
	public ResponseEntity<Tenant> registerAsTenant(@Valid @RequestBody Tenant tenant) throws TenantException{
		tenant.setPassword(passwordEncoder.encode(tenant.getPassword()));
		Tenant t=tser.registerAsTenant(tenant);
		return new ResponseEntity<Tenant>(t,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/tenant/{tenantid}")
	public ResponseEntity<Tenant> getTenantById(@PathVariable("tenantid") Integer tenantid) throws TenantException{
		Tenant t=tser.getTenantById(tenantid);
		return new ResponseEntity<Tenant>(t,HttpStatus.OK);
	}
	
	@PutMapping("/updatetenant")
	public ResponseEntity<Tenant> updateTenant(@Valid @RequestBody Tenant tenant) throws TenantException{
		tenant.setPassword(passwordEncoder.encode(tenant.getPassword()));
		Tenant t=tser.updateTenant(tenant);
		return new ResponseEntity<Tenant>(t,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/tenant/{tenantid}")
	public ResponseEntity<Tenant> deleteTenantById(@PathVariable("tenantid") Integer tenantid) throws TenantException{
		Tenant t=tser.deleteTenantById(tenantid);
		return new ResponseEntity<Tenant>(t,HttpStatus.OK);
	}
}
