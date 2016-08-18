package com.reliant.electricityservice.client.rest;

import org.apache.log4j.Logger;

import com.reliant.electricityservice.model.registration.Customer;
import com.reliant.electricityservice.service.registration.RegistrationService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Bootcamp User 017 Makes the rest call and gets the customer
 *         information
 */
public class CustomerClient {
	
	private static final Logger logger = Logger.getLogger(CustomerClient.class);
	/**
	 * Passes the customer Id to get the customer details
	 * 
	 * @param id
	 * @return
	 */
	public static Customer getCustomerById(int id) {
		
		Client client = Client.create();
		Customer customer = null;
		WebResource webResource = client.resource("http://localhost:7001/txuenergy/resources/getCustomer/" + id);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		try {
			customer = response.getEntity(Customer.class);
		} catch (ClientHandlerException e) {
			
			logger.error("Exception Occured in getEntity Method");
		} catch (UniformInterfaceException e){
			
			logger.error("Exception occured with getEntity");
		}

		return customer;
	}

}
