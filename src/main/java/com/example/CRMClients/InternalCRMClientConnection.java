package com.example.CRMClients;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.example.domain.ModelTO;
import com.example.internalcrm.service.InternalCRMService;
import com.example.internalcrm.service.InternalLeadDto;
import com.example.tools.Mapper;


public class InternalCRMClientConnection  {
	
	Mapper mapper;
	
	public InternalCRMClientConnection() {
		this.mapper = new Mapper();
	}
    
    public List<ModelTO> getAllUsers() throws Exception {
        // TODO Auto-generated method stub
    	TTransport tr = null ;
        try {
            tr = getTransport();
        }catch(TTransportException e){
            e.printStackTrace();
        }
        TProtocol protocol = new  TBinaryProtocol(tr);
        InternalCRMService.Client client = new InternalCRMService.Client(protocol);
        List<InternalLeadDto> listLeads = new ArrayList<>();
        try  {
            listLeads = client.findLeadsByDate(LocalDateTime.MIN.toString(),LocalDateTime.MAX.toString());
        }catch(TException e){
            e.printStackTrace();
        }
        List<ModelTO> modelTOList = new ArrayList<>();
        listLeads.forEach(element -> {modelTOList.add(mapper.fromInternalLeadDtoToModelTO(element));});
        tr.close();
        return modelTOList;
    }
    
    public void addUsers(List<ModelTO> listToMerge) throws Exception {
        // TODO Auto-generated method stub
    	TTransport tr = null ;
        try {
            tr = getTransport();
        }catch(TTransportException e){
            e.printStackTrace();
        }
        TProtocol protocol = new  TBinaryProtocol(tr);
        InternalCRMService.Client client = new InternalCRMService.Client(protocol);
        List<InternalLeadDto> listLeads = new ArrayList<>();
        try  {
            for(ModelTO data : listToMerge) {
            	client.addLead(Mapper.fromModelTOTOInternalLeadDto(data));
            }
        }catch(TException e){
            e.printStackTrace();
        }
        tr.close();
        
    }


    private TTransport getTransport() throws TTransportException{
	    TTransport transport;
	    transport = new TSocket("localhost", 9090);
	    transport.open();
	    return transport;

    }
    
}
