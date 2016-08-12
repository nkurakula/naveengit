package com.bootcampjava.electricityservice.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.services.registration.RegistrationService;

@Controller
public class ReistrationContoller {
	
	@Autowired
	RegistrationService regSercice;
	
	public void setRservice(RegistrationService regSercice) {
		this.regSercice = regSercice;
	}

	@RequestMapping("/registration")
    public void registratation(@ModelAttribute("customer") Customer customer) {			
		regSercice.saveCustomer(customer);

    }
}