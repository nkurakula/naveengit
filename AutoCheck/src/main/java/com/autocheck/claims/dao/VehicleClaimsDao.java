package com.autocheck.claims.dao;

import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import com.autocheck.claims.model.VehicleClaimsInfo;


public class VehicleClaimsDao {

	private static final Logger logger = LoggerFactory.getLogger(VehicleClaimsDao.class);
	@SuppressWarnings("unchecked")
	public VehicleClaimsInfo getVehicleClaimHistory(String vin) {
		// TODO Auto-generated method stub
		
		//Persistence class method to create Entity Manager Factory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ServiceProvider");
        //Entity manager 
		EntityManager entitymanager = emfactory.createEntityManager();
		VehicleClaimsInfo claimhistory = new VehicleClaimsInfo();
		try
		{
		// retrieve Vehicle claim history from entity manager interface find method using vin and object class.
			claimhistory= entitymanager.find(VehicleClaimsInfo.class,vin);
		
		}
		catch(Exception e)
		{
			logger.info("found Exception in querying the vin id from database");
			
			System.out.println("Exception found:" + e);
		}
		
		
		return claimhistory;
	}
	


	
}
