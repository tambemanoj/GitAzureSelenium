package com.tc_awc.constants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) {
		//1. load data from properties file
		String propFilePath ="data.properties";
		FileInputStream fis;
		try {
			InputStream is =PropertiesOperations.class.getClassLoader().getResourceAsStream(propFilePath);
			prop.load(is);
			//fis = new FileInputStream(propFilePath);
			//prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. read data
		String value = prop.get(key).toString();
		
		if(StringUtils.isEmpty(value)) {
			try {		
				throw new Exception("Value is not specified for key: "+key + " in properties file.");
			}catch(Exception e) {}
		}
		
		return value;
	}

}

