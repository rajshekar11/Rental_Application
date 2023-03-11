package com.rental.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties("tenant")
    @OneToMany(mappedBy = "tenant")
    private List<Booking> bookings=new ArrayList<>();
}
