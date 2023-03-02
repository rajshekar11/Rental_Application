package com.rental.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PropertyDTO {

	private String location;
	private Integer price;
	@Enumerated(EnumType.STRING)
	private PropertyType ptype;
	private Integer landlordId;
}
