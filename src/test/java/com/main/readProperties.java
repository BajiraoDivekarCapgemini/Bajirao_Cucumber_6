package com.main;

import java.io.FileInputStream;
import java.util.Properties;

public class readProperties {
	
	public  Properties readConfigData() {
		try {
			String path="./src/test/resources/application.properties";
			FileInputStream fis=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(fis);
			return prop;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
