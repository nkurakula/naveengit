package com.dmv.publicrecords.controller.driverinfo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.publicrecords.model.Driver;
import com.dmv.publicrecords.service.driverinfo.DriversInfoService;

@RestController
public class DriverController {

	@Autowired
	DriversInfoService driverSrv;

	@RequestMapping(value = "/getdriverhistory/{licenseNumbers}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public  ResponseEntity<List<Driver>> getDriverInfo(@PathVariable String licenseNumbers) {

		List<Driver> drList = driverSrv.getDriversInfo(licenseNumbers);
		return new ResponseEntity<List<Driver>>(drList, HttpStatus.OK);
	}

}
