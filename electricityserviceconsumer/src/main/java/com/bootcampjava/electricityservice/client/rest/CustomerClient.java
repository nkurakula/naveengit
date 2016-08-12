package com.bootcampjava.electricityservice.client.rest;


import com.bootcampjava.electricityservice.models.registration.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CustomerClient {
	
	
	public static Customer getCustomerById(int id){
				
		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:7001/txuenergy/resources/getCustomer/"+id);

		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}		
		Customer customer  = response.getEntity(Customer.class);	
		
		System.out.println("After REST call "+customer.getId());
	  	return customer;
	}	

}
