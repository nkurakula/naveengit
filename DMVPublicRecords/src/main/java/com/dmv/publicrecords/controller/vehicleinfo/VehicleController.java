package com.dmv.publicrecords.controller.vehicleinfo;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dmv.publicrecords.model.Vehicle;
import com.dmv.publicrecords.service.vehicleinfo.VehicleInfoService;

@RestController
public class VehicleController {
	@Autowired
	VehicleInfoService vehicleSrv;

	@RequestMapping(value = "/getvehicleslist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Vehicle>> getVehiclesList(@RequestBody String address) {

		List<Vehicle> vhList = vehicleSrv.getVehiclesList(address);
		return new ResponseEntity<List<Vehicle>>(vhList, HttpStatus.OK);
	}

}
