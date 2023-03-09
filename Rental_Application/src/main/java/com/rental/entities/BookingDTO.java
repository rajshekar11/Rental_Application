package com.rental.entities;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private int numberOfMonth;
    private int numberOfTenant;
    private int tenantID;
    private int propertyId;
}
