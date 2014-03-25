package com.eteng.driver.xgpush;

import com.eteng.mobile.IPushDriver;
import com.eteng.mobile.MessageBuilder;
import com.tencent.xinge.Message;
import com.tencent.xinge.XingeApp;


public class XGDriver implements IPushDriver {
	
	XingeApp app;
	
	@Override
	public void initialize(String appId, String privateKey) {
		app = new XingeApp(Long.parseLong(appId), privateKey);
	}

	@Override
	public void pushAll(Object message) {
		app.pushAllDevice(XingeApp.DEVICE_ALL, (Message) message);
	}

	@Override
	public MessageBuilder createBuilder() {
		return new XGMessageBuilder();
	}

}
