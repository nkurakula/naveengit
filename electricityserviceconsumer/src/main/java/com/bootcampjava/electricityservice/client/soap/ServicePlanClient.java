package com.bootcampjava.electricityservice.client.soap;


import java.util.List;
import com.bootcampjava.electricityservice.client.soap.wsimport.ServicePlan;
import com.bootcampjava.electricityservice.client.soap.wsimport.UtilityPlanService;
import com.bootcampjava.electricityservice.client.soap.wsimport.UtilityPlanServiceImplService;

public class ServicePlanClient {
	
	public static void main(String[] args) {
		
		UtilityPlanServiceImplService plan = new UtilityPlanServiceImplService();
		UtilityPlanService ups = plan.getUtilityPlanServiceImplPort();
		List<ServicePlan> planList = ups.getServicePlan();
		System.out.println("Outside loop"+planList);
		
		for(ServicePlan s : planList){
			
			System.out.println("List:"+s.getSId()+s.getSName()+s.getSAmount());

		}
		
	}
	
	
}
