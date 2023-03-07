package com.rental.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PropertyDTO2 {

	private String location;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private PropertyType ptype;
}
