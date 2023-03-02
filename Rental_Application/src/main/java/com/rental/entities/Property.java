package com.rental.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	private LandLord landlord;
}
