package com.txuenergy.customerutilityws.soaputilplan.service.restserv;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.txuenergy.customerutilityws.soaputilplan.dao.customer.CustomerDAO;
import com.txuenergy.customerutilityws.soaputilplan.entity.customer.Customer;

/**
 * @author Bootcamp User 017
 * Exposes services for consumer to get service plans
 */
@Path("/getCustomer")
public class CustomerService {
	
	/**
	 * Returns the customer based on id
	 * @param id
	 * @return
	 */
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Customer getServicePlan(@PathParam("id") int id) {
		
		Customer cust = CustomerDAO.getCustomerInfo(id);

		return cust;
	}
}
