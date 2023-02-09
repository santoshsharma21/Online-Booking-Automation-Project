/**
 * 
 */
package com.onlinebooking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Santosh Sharma
 *
 */
public class ReadConfig {
	
	public static Properties prop;
	
	public ReadConfig() {
		File src = new File(System.getProperty("user.dir") + "./configuration/config.properties");
		
		try {
			FileInputStream fip = new FileInputStream(src);
			prop = new Properties();
			prop.load(fip);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String url = prop.getProperty("baseurl");
		return url;
	}
	
	public String getEmail() {
		String email = prop.getProperty("emailid");
		return email;
	}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

}
