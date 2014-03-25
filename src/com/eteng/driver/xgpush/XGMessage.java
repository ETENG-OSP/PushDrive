package com.eteng.driver.xgpush;

import com.eteng.mobile.IMessage;
import com.tencent.xinge.Message;

public class XGMessage implements IMessage {
	
	Message message = new Message();

	@Override
	public void setTitle(String title) {
		message.setTitle(title);
	}

	@Override
	public void setText(String text) {
		message.setContent(text);
	}

	@Override
	public Object getRaw() {
		return message;
	}

}