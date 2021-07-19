package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	 public Properties prop;

	public  ConfigDataProvider() 
	{
	try
	
	{
	File fs=new File("./config/config.properties");	
		FileInputStream fis=new FileInputStream (fs);
		prop=new Properties();
		
		prop.load(fis);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public String getusername()
	{
		return prop.getProperty("username");
	}
	public String getpassword()
	{
		return prop.getProperty("password");
		
	}
	
	public String geturl()
	{
		return prop.getProperty("url");
	}
	
}
