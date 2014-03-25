package com.eteng.mobile;

import java.io.IOException;


public class PushService {
	
	IPushDriver driver;
	
	PushService() {
		try {
			String appId = Config.getAppId();
			String privateKey = Config.getPrivateKey();
			String driverName = Config.getDriver();
			
			driver = (IPushDriver) Class.forName(driverName).newInstance();
			driver.initialize(appId, privateKey);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	void pushAll(Message message) {
		MessageBuilder builder = driver.createBuilder();
		
		builder.setTitle(message.getTitle())
			.setText(message.getText());
		
		driver.pushAll(builder.build());
	}
	
	void pushAccount() {
	}
	
	void pushGroup() {
	}
	
	public static void main(String args[]) {
		
		PushService service = new PushService();
		Message message = new Message();
		message.setTitle("hello");
		message.setText("world");
		
		service.pushAll(message);
		
	}

}
