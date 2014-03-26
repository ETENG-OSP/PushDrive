package com.eteng.mobile;

import com.eteng.exception.PushException;
import com.eteng.util.Config;

public class Push {
	
	private PushDriver driver;
	
	private Push() {
		try {
			String appId = Config.getAppId();
			String privateKey = Config.getPrivateKey();
			String driverName = Config.getDriver();
			
			driver = (PushDriver) Class.forName(driverName).newInstance();
			driver.initialize(appId, privateKey);
			driver.reset();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Push title(String title) {
		driver.setTitle(title);
		return this;
	}
	
	public Push text(String text) {
		driver.setText(text);
		return this;
	}
	
	public Push expire(int ttl) {
		driver.setExpire(ttl);
		return this;
	}
	
	public static Push create() {
		return new Push();
	}

	public void toAll() throws PushException {
		this.driver.pushAll();
	}

	public void toAccount(String account) throws PushException {
		this.driver.pushAccount(account);
	}

	public void toGroup(String group) throws PushException {
		this.driver.pushGroup(group);
	}
	
	public static void main(String[] args) throws PushException {
		Push.create()
			.expire(0)
			.toAll();
	}

}
