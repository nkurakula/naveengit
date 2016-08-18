package com.txuenergy.customerutilityws.soaputilplan.service.soapserv;

import java.util.List;
import javax.jws.WebService;
import com.txuenergy.customerutilityws.soaputilplan.dao.electricity.ServiceDAO;
import com.txuenergy.customerutilityws.soaputilplan.entity.electricity.ServicePlan;

/**
 * Implementation class to get service plans
 * @author Bootcamp User 017
 *
 */
@WebService(endpointInterface = "com.txuenergy.customerutilityws.soaputilplan.service.soapserv.UtilityPlanService")
public class UtilityPlanServiceImpl implements UtilityPlanService{
	
	/**
	 * Returns the service plans from the database
	 */
	@Override
	public List<ServicePlan> getServicePlan(){
		
		List<ServicePlan> planList = ServiceDAO.getServicePlans();
		
		return planList;
	}
}
