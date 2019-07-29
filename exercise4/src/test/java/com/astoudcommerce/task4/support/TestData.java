package com.astoudcommerce.task4.support;

import java.io.FileInputStream;
import java.util.Properties;

public class TestData {
	private Properties properties;
	
	public TestData() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("testData")));
		} catch (Exception e) {

		}
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	
	
}
