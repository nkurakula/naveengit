package com.txuenergy.customerutilityws.soaputilplan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author Bootcamp User 017 Utility Class to get the required properties and
 *         connect to database
 */
public class DBUtil {

	public static Connection getConnection() {

		String url = PropertiesHandler.getProperties().getProperty("url");
		String dbName = PropertiesHandler.getProperties().getProperty("database") + "?useSSL=false";
		String driver = PropertiesHandler.getProperties().getProperty("driver");
		// String driver = "com.mysql.jdbc.Driver";
		String userName = PropertiesHandler.getProperties().getProperty("dbuser");
		String password = PropertiesHandler.getProperties().getProperty("dbpassword");

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, password);

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			e.printStackTrace();

		}
		return conn;
	}

	public static Connection getDataSourceConnection() {

		Connection conn = null;
		javax.sql.DataSource ds = null;
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://localhost:7001");

		try {
			Context context = new InitialContext(env);
			ds = (javax.sql.DataSource) context.lookup("txuDs");
			conn = ds.getConnection();
			System.out.println("Connection: " + conn);
		} catch (Exception ex) {
			// handle the exception
			ex.printStackTrace();
		}

		return conn;
	}

}
