package com.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entities.Tenant;
import com.rental.entities.TenantDTO;
import com.rental.exceptions.TenantException;
import com.rental.repository.TenantRepository;

@Service
public class TenantServiceImpl implements TenantService {
	
	@Autowired
	private TenantRepository trep;

	@Override
	public Tenant registerAsTenant(TenantDTO tenant) throws TenantException {
		Tenant t=new Tenant();
		t.setContactNumber(tenant.getContactNumber());
		t.setEmail(tenant.getEmail());
		t.setFirstName(tenant.getFirstName());
		t.setLastName(tenant.getLastName());
		return trep.save(t);
	}

	@Override
	public Tenant getTenantById(Integer tenantid) throws TenantException {
		Optional<Tenant> opt=trep.findById(tenantid);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new TenantException("There are no tenant by Id: "+tenantid);
	}

}
