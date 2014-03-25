package com.eteng.mobile;

import java.io.IOException;
import java.util.List;

import com.eteng.exception.PushException;


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
	
	void pushAll(IMessage message) throws PushException {		
		driver.pushAll(message);
	}
	
	void pushAccount(String account, IMessage message) throws PushException {
		driver.pushAccount(account, message);
	}
	
	void pushAccount(List<String> accounts, IMessage message) throws PushException {
		for (String account: accounts) {
			pushAccount(account, message);
		}
	}
	
	void pushGroup(String group, IMessage message) throws Exception {
		throw new Exception("not implements");
	}
	
	private MessageBuilder createBuilder() {
		IMessage message = driver.createMessage();
		MessageBuilder builder = new MessageBuilder(message);
		return builder;
	}
	
	public static void main(String args[]) throws Exception {
		
		PushService service = new PushService();
		MessageBuilder builder = service.createBuilder();
		service.pushAccount("tester", builder.build());
	}

}
