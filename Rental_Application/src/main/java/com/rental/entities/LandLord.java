package com.rental.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class LandLord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lId;
    private String firstName;
    private String lastName;
    @Email(message = "Please enter correct email address")
    private String email;
    @Size(min = 10, message = "Mobile number should be of 10 digits")
    private String contactNumber;
    @JsonIgnoreProperties("landlord")
    @OneToMany(mappedBy = "landlord", fetch = FetchType.LAZY)
    private List<Property> properties=new ArrayList<>();
}
