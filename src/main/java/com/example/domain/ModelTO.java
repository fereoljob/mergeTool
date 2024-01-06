package com.example.domain;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModelTO {
	private String firstName;
    private String lastName;
    private double annualRevenue;
    private String phone;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private String company;
    private LocalDateTime creationDate;
    private String state;
    
    @Override
	public String toString() {
	    return "ModelTO{" +
	            "_firstName='" + firstName + '\'' +
	            ", _lastName='" + lastName + '\'' +
	            ", _annualRevenue=" + annualRevenue +
	            ", _phone='" + phone + '\'' +
	            ", _street='" + street + '\'' +
	            ", _postalCode='" + postalCode + '\'' +
	            ", _city='" + city + '\'' +
	            ", _country='" + country + '\'' +
	            ", _company='" + company + '\'' +
	            ", _state='" + state + '\'' +
	             ", creationDate='" + creationDate + '\'' +
	            '}';
	
	}
	
}
