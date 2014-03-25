package com.eteng.mobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;

public class Config {
	
	private static JSONObject config;
	
	private static void init() throws IOException {
		if (config == null) {
			File file = new File("config/push.json");
			
			FileInputStream inputStream = new FileInputStream(file);
			int length = (int) file.length();
			byte[] buffer = new byte[length];
			inputStream.read(buffer);
			inputStream.close();
			
			config = new JSONObject(new String(buffer));
		}
	}
	
	public static String getAppId() throws IOException {
		init();
		return config.getString("app-id");
	}
	
	public static String getPrivateKey() throws IOException {
		init();
		return config.getString("private-key");
	}
	
	public static String getDriver() throws IOException {
		init();
		return config.getString("driver");
	}

}
