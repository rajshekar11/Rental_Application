package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.entities.Tenant;
import com.rental.repository.TenantRepository;

@RestController
public class LoginController {

	@Autowired
	private TenantRepository trep;
	
	@GetMapping("/signIn")
	public ResponseEntity<Tenant> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		 Tenant t= trep.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		 return new ResponseEntity<>(t, HttpStatus.ACCEPTED);
		
	}
	
}
