package com.reliant.electricityservice.client.soap;


import java.util.List;
import com.reliant.electricityservice.client.soap.mavimport.ServicePlan;
import com.reliant.electricityservice.client.soap.mavimport.UtilityPlanService;
import com.reliant.electricityservice.client.soap.mavimport.UtilityPlanServiceImplService;

/**
 * @author Bootcamp User 017 Java Client to make soap call to get the list of
 *         plans
 */
public class ServicePlanClient {

	/**
	 * Gets the list of service plans
	 * @return
	 */
	public static List<ServicePlan> getPlanList() {

		UtilityPlanServiceImplService plan = new UtilityPlanServiceImplService();
		UtilityPlanService ups = plan.getUtilityPlanServiceImplPort();
		List<ServicePlan> planList = ups.getServicePlan();

		return planList;
	}

}
