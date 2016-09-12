package com.autocheck.claims.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.autocheck.claims.model.VehicleClaimsInfo;


@WebService
public interface VehicleClaimsService {

	@WebMethod
	public VehicleClaimsInfo getVehicleClaimHistory(String vin);
}
