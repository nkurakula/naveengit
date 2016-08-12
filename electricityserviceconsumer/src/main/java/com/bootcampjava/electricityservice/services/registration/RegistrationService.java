package com.bootcampjava.electricityservice.services.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcampjava.electricityservice.client.rest.CustomerClient;
import com.bootcampjava.electricityservice.daos.registration.RegistrationDAO;
import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.services.jms.UtilityMessageSender;

public class RegistrationService {

	@Autowired
	RegistrationDAO regDAO;
	
	@Autowired
	UtilityMessageSender sender;
	
	@Transactional
	public void saveCustomer(Customer customer) {
		int id = regDAO.saveCustomer(customer);
		
		Customer cust = CustomerClient.getCustomerById(id);
		
		System.out.println("Before Sending the message "+2+" "+cust.getId());
		sender.sendMessage(2+" "+cust.getId());

		System.out.println("Message was send....***************....");

	}
}
