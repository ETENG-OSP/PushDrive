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
	
	void pushAll(IMessage message) {		
		driver.pushAll(message);
	}
	
	void pushAccount() {
	}
	
	void pushGroup() {
	}
	
	public static void main(String args[]) {
		
		PushService service = new PushService();
		MessageBuilder builder = service.createBuilder()
		    .setTitle("Hello")
			.setText("World");
		
		service.pushAll(builder.build());
	}

	private MessageBuilder createBuilder() {
		IMessage message = driver.createMessage();
		MessageBuilder builder = new MessageBuilder(message);
		return builder;
	}

}
