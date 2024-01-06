package com.example.tools;

import java.util.List;

import com.example.CRMClients.InternalCRMClientConnection;
import com.example.CRMClients.SalesforceCRMClientConnection;
import com.example.domain.ModelTO;
import com.example.internalcrm.service.InternalLeadDto;

public class Merger {
	
	private SalesforceCRMClientConnection salesforceClient;
	private InternalCRMClientConnection internalClient;
	
	public Merger() throws Exception {
		this.salesforceClient = new SalesforceCRMClientConnection();
		this.internalClient = new InternalCRMClientConnection();
	}
	
	public void mergeLeads() throws Exception {
		System.out.println("Merge Tool Begins");
		List<ModelTO> internalDatas = internalClient.getAllUsers();
		System.out.println("Internal Data before Merge : ");
		System.out.println("Number of Elements : " +internalDatas.size() + "\n");
		for(ModelTO iData : internalDatas) {
			System.out.println(iData.toString());
		}
		
		
		List<ModelTO> clientsToMerge = salesforceClient.getAllUsers();
		
		internalClient.addUsers(clientsToMerge);
		internalDatas = internalClient.getAllUsers();
		System.out.println("----------------------------------\n");
		System.out.println("Internal Data After Merge : ");
		System.out.println("Number of Elements : " +internalDatas.size() + "\n");
		System.out.println("----------------------------------\n");

		for(ModelTO iData : internalDatas) {
			System.out.println(iData.toString());
		}
		System.out.println("----------------------------------\n");
		System.out.println("Merge done");
		
	}

}
