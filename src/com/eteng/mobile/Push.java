package com.eteng.mobile;

import com.eteng.exception.PushException;
import com.eteng.util.Config;

public class Push {
	
	private PushDriver driver;
	
	Push() {
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
	
	Push title(String title) {
		driver.setTitle(title);
		return this;
	}
	
	Push text(String text) {
		driver.setText(text);
		return this;
	}
	
	Push expire(int ttl) {
		driver.setExpire(ttl);
		return this;
	}
	
	public static void main(String[] args) throws PushException {
		new Push()
			.title("")
			.text("")
			.toAll();
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

}
