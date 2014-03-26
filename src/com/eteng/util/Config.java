package com.eteng.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;

import et.common.util.ClassUtility;

public class Config {
	
	private static JSONObject config;
	private static final String FILE = "config/push.json";
	
	private static final int BUFFER_SIZE = 32;
	
	private static void init() throws IOException {
		if (config == null) {
		    InputStream input = ClassUtility.loadResource(FILE);
		    ByteArrayOutputStream output = new ByteArrayOutputStream();
		    byte[] buffer = new byte[BUFFER_SIZE];
		    while (true) {
		        int len = input.read(buffer);
		        if (len < 0) {
		            break;
		        }
		        output.write(buffer, 0, len);
		    }
		    
		    String text = new String(output.toByteArray());
		    config = new JSONObject(text);
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
