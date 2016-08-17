 package com.reliant.electricityservice.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.reliant.electricityservice.model.registration.Customer;
import com.reliant.electricityservice.service.registration.RegistrationService;

@Controller
public class RegistrationContoller {
	
	@Autowired
	RegistrationService regService;
	
	public void setRservice(RegistrationService regService) {
		this.regService = regService;
	}

	@RequestMapping("/registration")
    public void registratation(@ModelAttribute("customer") Customer customer) {			
		regService.saveCustomer(customer);

    }
}