package com.crm.objrep;

import java.io.FileInputStream;
import java.util.Properties;

public class CrmObjects {
	
	public FileInputStream fis = null;
	public Properties prop = null;
	
	public Properties getObject() {
		try { 
			fis = new FileInputStream("src//test//resources//crm_objects.properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Objects not recognised");
			e.printStackTrace();
			
		}
		
		return prop;
	}
	

}
