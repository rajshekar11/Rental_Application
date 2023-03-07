package com.rental.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    
    @OneToMany(mappedBy = "tenant")
    List<Booking> bookings;
}
