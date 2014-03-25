package com.eteng.driver;

import java.util.Map;

import com.eteng.exception.PushException;
import com.eteng.mobile.PushDriver;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;

public class XGPushDriver extends PushDriver {
	
	XingeApp app;
	Message message;

	@Override
	public void setType(Type type) {
		switch (type) {
		case TYPE_APP:
			message.setType(Message.TYPE_MESSAGE);
			break;
		case TYPE_SMS:
			message.setType(Message.TYPE_NOTIFICATION);
		}
	}

	@Override
	public void setTitle(String title) {
		message.setTitle(title);
	}

	@Override
	public void setText(String text) {
		message.setContent(text);
	}

	@Override
	public void setExtra(Map<String, Object> extra) {
		message.setCustom(extra);
	}

	@Override
	public void setExpire(int ttl) {
		message.setExpireTime(ttl);
	}

	@Override
	public void initialize(String appId, String privateKey) {
		app = new XingeApp(Long.parseLong(appId), privateKey);
		message = new Message();
		message.setAction(new ClickAction());
		message.setStyle(new Style(0, 1, 1, 1, 0));
	}

	@Override
	public void pushAll() throws PushException {
		app.pushAllDevice(XingeApp.DEVICE_ALL, message);
	}

	@Override
	public void pushAccount(String account) throws PushException {
	}

	@Override
	public void pushGroup(String group) throws PushException {
	}

}
