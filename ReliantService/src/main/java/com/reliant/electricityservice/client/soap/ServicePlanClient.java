package com.reliant.electricityservice.client.soap;


import java.util.List;

import com.reliant.electricityservice.client.soap.mavimport.ServicePlan;
import com.reliant.electricityservice.client.soap.mavimport.UtilityPlanService;
import com.reliant.electricityservice.client.soap.mavimport.UtilityPlanServiceImplService;


public class ServicePlanClient {
	
	public static  List<ServicePlan> getPlanList() {
		
		UtilityPlanServiceImplService plan = new UtilityPlanServiceImplService();
		UtilityPlanService ups = plan.getUtilityPlanServiceImplPort();
		List<ServicePlan> planList = ups.getServicePlan();
		
		return planList;
	}
	
	
}
