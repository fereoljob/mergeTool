package com.example.tools;


import java.time.LocalDateTime;

import com.example.domain.ModelTO;
import com.example.internalcrm.service.InternalLeadDto;



public class Mapper {
	
	 
	    public static InternalLeadDto fromModelTOTOInternalLeadDto(ModelTO obj){
	        InternalLeadDto lead = new InternalLeadDto(obj.getFirstName()+","+ obj.getLastName(), obj.getAnnualRevenue(),
	        obj.getPhone(), obj.getStreet(),obj.getPostalCode(),obj.getCity(), obj.getCountry(),
	         obj.getCreationDate().toString(),obj.getCompany(),obj.getState());
	         return lead;
	    }
	    
	    public ModelTO fromInternalLeadDtoToModelTO(InternalLeadDto dataType) {
	        String[] tab = dataType.getName().split(",");
	        ModelTO model = new ModelTO(tab[0],tab[1],dataType.getAnnualRevenue(), dataType.getPhone(), dataType.getStreet(), dataType.getPostalCode(),
	          dataType.getCity(), dataType.getCountry(), dataType.getCompany(), LocalDateTime.parse(dataType.getCreationDate()), dataType.getState());
	        return model;
	    }

}
