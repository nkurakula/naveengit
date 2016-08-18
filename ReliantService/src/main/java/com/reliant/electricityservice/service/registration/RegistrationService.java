package com.reliant.electricityservice.service.registration;


import java.util.List;
import javax.jms.JMSException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.reliant.electricityservice.client.rest.CustomerClient;
import com.reliant.electricityservice.client.soap.ServicePlanClient;
import com.reliant.electricityservice.client.soap.mavimport.ServicePlan;
import com.reliant.electricityservice.dao.registration.RegistrationDAO;
import com.reliant.electricityservice.model.registration.Customer;
import com.reliant.electricityservice.service.jms.UtilityMessageSender;

/**
 * @author Bootcamp User 017 Process the customer information by making rest,
 *         soap and jms calls
 */
public class RegistrationService {

	private static final Logger logger = Logger.getLogger(RegistrationService.class);

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	UtilityMessageSender sender;

	/**
	 * Makes a rest call to get the customer details and then based on the
	 * customer id sends the message to jms queue after getting one plan list
	 * through soap call and selecting one of them and setting it to customer
	 * id.
	 * 
	 * @param customer
	 * @return
	 */
	@Transactional
	public int saveCustomer(Customer customer) {

		int id = regDAO.saveCustomer(customer);

		try {

			Customer cust = CustomerClient.getCustomerById(id);

			List<ServicePlan> planList = ServicePlanClient.getPlanList();

			if (cust != null) {
				if (planList != null) {
					try {
						sender.sendMessage(planList.get(0).getSId() + " " + cust.getId());
					} catch (JMSException e) {
						logger.error("Error occured while sending the message");
					}
					customer.setServiceId(planList.get(0).getSId());
					logger.error("Message Sent to JMS");
				} else
					logger.error("PlanList is equal to null");
			}

			else
				logger.error("customer object is set to null");
		} catch (RuntimeException e) {

			logger.error("Error while getting the response");
		}
		return id;
	}
}
