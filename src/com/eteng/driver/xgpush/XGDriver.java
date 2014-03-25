package com.eteng.driver.xgpush;

import org.json.JSONObject;

import com.eteng.exception.PushException;
import com.eteng.mobile.IMessage;
import com.eteng.mobile.IPushDriver;
import com.tencent.xinge.Message;
import com.tencent.xinge.XingeApp;


public class XGDriver implements IPushDriver {
	
	private XingeApp app;
	private static final int DEVICE_TYPE = XingeApp.DEVICE_ALL;
	
	private static final String RET_CODE = "ret_code";
	
	private static final int INVALID_MESSAGE = -1;
	private static final int INVALID_SIGN = -3;
	
	@Override
	public void initialize(String appId, String privateKey) {
		app = new XingeApp(Long.parseLong(appId), privateKey);
	}
	
	@Override
	public IMessage createMessage() {
		return new XGMessage();
	}

	@Override
	public void pushAll(IMessage message) throws PushException {
		Message raw = (Message) message.getRaw();
		JSONObject result = app.pushAllDevice(DEVICE_TYPE, raw);
		System.out.println(result);
		
		int retCode = result.getInt(RET_CODE);
		switch (retCode) {
		case INVALID_MESSAGE:
			throw new PushException("asdf");
		case INVALID_SIGN:
			throw new PushException("asdf2");
		}
	}

	@Override
	public void pushAccount(String account, IMessage message) throws PushException {
		JSONObject result = app.pushSingleAccount(DEVICE_TYPE, account, (Message) message.getRaw());
		System.out.println(result);
		
		int retCode = result.getInt(RET_CODE);
		switch (retCode) {
		case INVALID_MESSAGE:
			throw new PushException("asdf");
		case INVALID_SIGN:
			throw new PushException("asdf2");
		}
	}

}
