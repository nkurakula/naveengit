package com.assurance.claims.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.assurance.claims.history.webservice.ServiceProvider;
import com.assurance.claims.history.webservice.VehicleClaimsInfo;
import com.assurance.claims.history.webservice.VehicleClaimsService;

@Path("/claims")
public class ClaimsHistory {

	@Path("{param}")
	@GET
	@Produces("application/json")
	public VehicleClaimsInfo getClaimsHistory(@PathParam("param") String vin) {
		
		ServiceProvider swsService = new ServiceProvider();

		VehicleClaimsService servicePlanWS = swsService.getVehicleClaimsServiceImplPort();

		return servicePlanWS.getVehicleClaimHistory(vin);

	}

}