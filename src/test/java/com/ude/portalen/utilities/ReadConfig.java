package com.ude.portalen.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception is" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	public String getDeviceName() {

		String device = pro.getProperty("deviceName");
		return device;
	}

	public String getPlatformVersion() {

		String platformVersion = pro.getProperty("platformVersion");
		return platformVersion;
	}

	public String getEmailAddress() {
		String gmail = pro.getProperty("email");
		return gmail;

	}

	public String base_url() {
		String gmail = pro.getProperty("Base_URL");
		return gmail;

	}

	public String browser_selection() {
		String gmail = pro.getProperty("Browser");
		return gmail;

	}	
}