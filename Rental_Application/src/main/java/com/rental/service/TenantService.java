package com.rental.service;

import com.rental.entities.Tenant;
import com.rental.entities.TenantDTO;
import com.rental.exceptions.TenantException;

public interface TenantService {

	public Tenant registerAsTenant(Tenant tenant) throws TenantException;
	
	public Tenant getTenantById(Integer tenantid) throws TenantException;
	
	public Tenant updateTenant(Tenant tenant) throws TenantException;
	
	public Tenant deleteTenantById(Integer tenantid) throws TenantException;
}
