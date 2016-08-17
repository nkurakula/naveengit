package com.reliant.electricityservice.service.registration;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.reliant.electricityservice.client.rest.CustomerClient;
import com.reliant.electricityservice.client.soap.ServicePlanClient;
import com.reliant.electricityservice.client.soap.mavimport.ServicePlan;
import com.reliant.electricityservice.dao.registration.RegistrationDAO;
import com.reliant.electricityservice.model.registration.Customer;
import com.reliant.electricityservice.service.jms.UtilityMessageSender;


public class RegistrationService {

	private static final Logger logger = Logger.getLogger(RegistrationService.class);

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	UtilityMessageSender sender;

	@Transactional
	public void saveCustomer(Customer customer) {
		int id = regDAO.saveCustomer(customer);

		Customer cust = CustomerClient.getCustomerById(id);
		List<ServicePlan> planList = ServicePlanClient.getPlanList();

		System.out.println("Before Sending the message " + 2 + " " + cust.getId());
		sender.sendMessage(planList.get(1).getSId() + " " + cust.getId());
		logger.info("Message Sent to JMS");
		System.out.println("Message was send....***************....");

	}
}
