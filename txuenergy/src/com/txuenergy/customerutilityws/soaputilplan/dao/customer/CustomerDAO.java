package com.txuenergy.customerutilityws.soaputilplan.dao.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.txuenergy.customerutilityws.soaputilplan.entity.customer.Customer;
import com.txuenergy.customerutilityws.soaputilplan.util.DBUtil;

public class CustomerDAO {
	
	public static Customer getCustomerInfo(int id){
		
		Connection con = DBUtil.getConnection();
		Customer cust =  new Customer();
		
		if(con!=null){
			
			try {
				Statement stmt=con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from customer where cid="+id);
				
				while(rs.next()){
					
					cust.setId(rs.getInt(1));
					cust.setFirstname(rs.getString(2));
					cust.setLastname(rs.getString(3));
					cust.setEmail(rs.getString(4));
					cust.setTelephone(rs.getString(7));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}  
			finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return cust;
	}

	public static void updateCustomerDetails(int cid, int sId) {
		
		Connection con = DBUtil.getConnection();
		

		
		try {
			Statement stmt=con.createStatement();
			int rs = stmt.executeUpdate("update customer set serviceId="+sId+" where cid="+cid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
