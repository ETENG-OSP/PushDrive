package com.eteng.driver.xgpush;

import com.eteng.mobile.IMessage;
import com.eteng.mobile.IPushDriver;
import com.tencent.xinge.Message;
import com.tencent.xinge.XingeApp;


public class XGDriver implements IPushDriver {
	
	XingeApp app;
	
	@Override
	public void initialize(String appId, String privateKey) {
		app = new XingeApp(Long.parseLong(appId), privateKey);
	}

	@Override
	public void pushAll(IMessage message) {
		Message raw = (Message) message.getRaw();
		app.pushAllDevice(XingeApp.DEVICE_ALL, raw);
	}

	@Override
	public IMessage createMessage() {
		return new XGMessage();
	}

}
