package com.rental.entities;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class BookingDTO {

    private int numberOfMonth;
    private int numberOfTenant;
    private int tenantID;
    private int propertyId;
}
