package com.eteng.mobile;

import com.eteng.driver.xgpush.XGDriver;

public class PushService {
	
	IPushDriver driver;
	
	PushService() {
		driver = new XGDriver();
	}
	
	void pushAll(Message message) {
		MessageBuilder builder = driver.createBuilder();
		
		builder.setTitle(message.getTitle())
			.setText(message.getText());
		
		driver.pushAll(builder.build());
	}
	
	void pushAccount() {
		
	}

}
