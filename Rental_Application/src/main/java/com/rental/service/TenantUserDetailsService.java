package com.rental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental.entities.Tenant;
import com.rental.repository.TenantRepository;

@Service
public class TenantUserDetailsService implements UserDetailsService {

	@Autowired
	private TenantRepository trep;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<Tenant> opt= trep.findByEmail(username);

		if(opt.isPresent()) {
			
			Tenant t= opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			return new User(t.getEmail(), t.getPassword(), authorities);
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		
	}

}



