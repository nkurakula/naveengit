package com.txuenergy.customerutilityws.soaputilplan.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author Bootcamp User 017
 * Reads the properties from a file and return properties object
 */
public class PropertiesHandler {
	
	/**
	 * Gets the properties from the Application properties file
	 * @return
	 */
	public static Properties getProperties(){

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("C:\\BCJMay16\\Developer\\MIddleLayer\\Workspace\\java\\springworkspace\\txuenergy\\ApplicationResources.properties");

			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	  }
}
