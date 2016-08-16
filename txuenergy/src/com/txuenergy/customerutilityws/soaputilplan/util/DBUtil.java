package com.txuenergy.customerutilityws.soaputilplan.util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Bootcamp User 017
 * Utility Class to get the required properties and connect to database
 */
public class DBUtil {
	
	public static Connection getConnection(){
		
		String url = PropertiesHandler.getProperties().getProperty("url");
        String dbName = PropertiesHandler.getProperties().getProperty("database")+"?useSSL=false";
        String driver = PropertiesHandler.getProperties().getProperty("driver");
        //String driver = "com.mysql.jdbc.Driver";
        String userName = PropertiesHandler.getProperties().getProperty("dbuser");
        String password = PropertiesHandler.getProperties().getProperty("dbpassword");
		
        Connection conn = null;
        
        try
	    {
			Class.forName(driver);
		    conn = DriverManager.getConnection(url + dbName,userName , password);
		    
		    return conn;
	    }catch (Exception e)
        {
		      System.err.println("Got an exception! ");
		      e.printStackTrace();
		      
		      return null;
		    }
		
	}
}
