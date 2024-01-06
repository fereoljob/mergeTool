package com.example.tools;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.example.domain.ModelTO;

public class SalesforceCRMDataConverter implements CRMDataConverter
<Map<String, Object> >{
	
	public SalesforceCRMDataConverter() {
		
	}

	@Override
	public ModelTO convertDatas(Map<String, Object> dataType) {
		
        double revenue = -1;
        String street = "";
        String city ="";
        String country = "";
        String postalCode = "";
        
        //Suite de conditions pour traiter les paramètres ayant besoin d'être uniformisés pour le reste de l'application 
        if(dataType.get("AnnualRevenue")!=null) {
        	revenue = (double)dataType.get("AnnualRevenue");
        }
        if(dataType.get("Street")!=null) {
        	street = (String)dataType.get("Street");
        }
        if(dataType.get("City")!=null) {
        	city = (String)dataType.get("City");
        }
        if(dataType.get("Country")!=null) {
        	country = (String)dataType.get("Country");
        }
        if(dataType.get("PostalCode")!=null) {
        	postalCode = (String)dataType.get("PostalCode");
        }
      
      

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		
		ModelTO model = new ModelTO((String) dataType.get("FirstName"), (String) dataType.get("LastName"),
		revenue,
		 (String) dataType.get("Phone"), street, postalCode,city, country, (String) dataType.get("CompanyName"),
		   LocalDateTime.parse((String)dataType.get("CreatedDate"),formatter), (String) dataType.get("State"));
		
		return model;
	}

	
	

}
 
