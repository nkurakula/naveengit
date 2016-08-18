package com.reliant.electricityservice.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reliant.electricityservice.model.registration.Customer;
import com.reliant.electricityservice.service.registration.RegistrationService;

/**
 * @author Bootcamp User 017
 * Controls the flow for registration functionality
 */
@Controller
public class RegistrationContoller {

	@Autowired
	RegistrationService regService;

	public void setRservice(RegistrationService regService) {
		this.regService = regService;
	}
	
	/**
	 * Registers the customer  
	 * @param customer
	 * @return
	 */
	@RequestMapping("/registration")
	public String registerCustomer(@ModelAttribute("customer") Customer customer) {

		int id = regService.saveCustomer(customer);
		if (id > 0)
			return "success";
		else
			return "fail";
	}
}