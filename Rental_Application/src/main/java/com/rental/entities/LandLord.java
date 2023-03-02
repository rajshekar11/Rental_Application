package com.rental.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class LandLord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    
    @OneToMany(mappedBy = "landlord", fetch = FetchType.LAZY)
    private List<Property> properties;
}
