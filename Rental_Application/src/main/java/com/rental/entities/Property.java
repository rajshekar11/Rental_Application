package com.rental.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	private String location;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private PropertyType ptype;
	@JsonIgnoreProperties("properties")
	@ManyToOne
	private LandLord landlord;
	@JsonIgnoreProperties({"property"})
	@OneToMany(mappedBy = "property")
	private List<Booking> bookings=new ArrayList<>();
}
