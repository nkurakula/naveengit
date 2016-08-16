package com.txuenergy.customerutilityws.soaputilplan.dao.electricity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.txuenergy.customerutilityws.soaputilplan.entity.electricity.ServicePlan;
import com.txuenergy.customerutilityws.soaputilplan.util.DBUtil;

public class ServiceDAO {
	
	public static List<ServicePlan> getServicePlans(){
		
		List<ServicePlan> planList = new ArrayList<ServicePlan>(); 
		
		Connection con = DBUtil.getConnection();
		
		if(con!=null){
			
			try {
				Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from electricity_plans");
				
				while(rs.next()){
					
					ServicePlan sp = new ServicePlan();
					sp.setsId(rs.getInt(1));
					sp.setsName(rs.getString(2));
					sp.setsAmount(rs.getFloat(3));
					
					planList.add(sp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  
		}
		
		return planList;
	}
}
