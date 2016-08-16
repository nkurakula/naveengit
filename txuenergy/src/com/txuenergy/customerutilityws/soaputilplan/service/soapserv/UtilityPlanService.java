package com.txuenergy.customerutilityws.soaputilplan.service.soapserv;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.txuenergy.customerutilityws.soaputilplan.entity.electricity.ServicePlan;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface UtilityPlanService {
	
	@WebMethod
	public List<ServicePlan> getServicePlan();
}
